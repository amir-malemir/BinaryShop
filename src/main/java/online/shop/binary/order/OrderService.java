package online.shop.binary.order;


import online.shop.binary.base.BaseService;
import online.shop.binary.warehouse.*;
import online.shop.binary.cart.*;
import online.shop.binary.cartitem.CartItem;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService extends BaseService<Order, OrderRepository> {
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartService cartService;
	
	@Transactional
	public Order checkout(Long cartId) {
		Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("cart not found"));
		Order order = repository.findById(cartId).orElseThrow(() -> new RuntimeException("Order not found"));
		
		cartService.validateStock(cartId);
				
		for(CartItem cartItem : cart.getItems()){
			
			Warehouse warehouse = warehouseRepository.findByProductId(cartItem.getProduct().getId()).orElseThrow(() -> new RuntimeException("Warehouse not found"));
			OrderItem orderItem = new OrderItem();
			orderItem.setOrder(order);
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setQuantity(cartItem.getQuantity());
			order.getItems().add(orderItem);
			warehouse.setQuantity(warehouse.getQuantity() - cartItem.getQuantity());
			warehouseRepository.save(warehouse);
		
		}
		
		order.setUser(cart.getUser());
		order.setOrderDate(LocalDateTime.now());
		order.setStatus("confirmed");
		repository.save(order);
	}
}