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
	

	private final WarehouseRepository warehouseRepository;
	
	public CartService(CartRepository repository,
			WarehouseRepository warehouseRepository) {
		super(repository);
		this.warehouseRepository = warehouseRepository;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private CartStatus status = CartStatus.ACTIVE;
	
	public CartStatus getStatus() {
	    return status;
	}

	public void setStatus(CartStatus status) {
	    this.status = status;
	}
	
	@Transactional
	public void validateStock(Long cartId) {
		Cart cart = repository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
		for(CartItem item: cart.getItems()){
			Warehouse warehouse = warehouseRepository.findByProductId(item.getProduct().getId()).orElseThrow(() -> new RuntimeException("warehouse not found"));
			if(warehouse.getQuantity() < item.getQuantity()) {
				throw new RuntimeException("Stock not enough!");
			}
		}
	}
	
}
