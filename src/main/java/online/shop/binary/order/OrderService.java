itory.findByProductId(cartItem.getProduct().getId()).orElseThrow(() -> new RuntimeException("warehouse not found"));
			
			OrderItem orderItem = new OrderItem();
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setOrder(package online.shop.binary.order;

import online.shop.binary.base.BaseService;
import online.shop.binary.warehouse.*;
import online.shop.binary.cart.*;
import online.shop.binary.cartitem.CartItem;

import java.time.LocalDateTime;

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
		
		cartService.validateStock(cartId);
		
		Order order = new Order();
		
		for(CartItem cartItem : cart.getItems()){
			Warehouse warehouse = warehouseRepository.findByProductId(cartItem.getProduct().getId());
			if(warehouse.getQuantity() < cartItem.getQuantity()) {
				throw new RuntimeException("Stock not enough");
			}
		
		warehouse.setQuantity(warehouse.getQuantity() - cartItem.getQuantity());
		warehouseRepository.save(warehouse);
		
		}
		
		order.setUser(cart.getUser());
		order.setOrderDate(LocalDateTime.now());
		order.setStatus("confirmed");
		repository.save(order);
		
//		
//		Order order = repository.findById(cartId)
//		        .orElseThrow(() -> new RuntimeException("Order not found"));		
//		for(OrderItem item:order.getItems()) {
//			Warehouse warehouse = warehouseRepository
//			        .findByProductId(item.getProduct().getId())
//			        .orElseThrow(() -> new RuntimeException("Warehouse not found"));			
//			if(warehouse.getQuantity() < item.getQuantity()) {
//				throw new RuntimeException("Stock not enough");
//			}
//			
//		warehouse.setQuantity(warehouse.getQuantity() - item.getQuantity());
//		warehouseRepository.save(warehouse);
//		}
//		order.setStatus("confirmed");
//		repository.save(order);
//	}
	}
}