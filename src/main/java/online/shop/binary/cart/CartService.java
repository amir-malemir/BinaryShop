package online.shop.binary.cart;

import javax.transaction.Transactional;
import online.shop.binary.warehouse.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.shop.binary.base.BaseService;
import online.shop.binary.cartitem.CartItem;
import online.shop.binary.warehouse.Warehouse;
import online.shop.binary.warehouse.WarehouseRepository;

@Service
public class CartService extends BaseService<Cart, CartRepository> {
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Transactional
	public void cartDetails(Long cartId) {
		Cart cart = repository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
		for(CartItem item: cart.getItems()){
			Warehouse warehouse = warehouseRepository.findByProductId(item.getProduct().getId()).orElseThrow(() -> new RuntimeException("warehouse not found"));
			if(warehouse.getQuantity() < item.getQuantity()) {
				throw new RuntimeException("Stock not enough!");
			}
		}
	}
