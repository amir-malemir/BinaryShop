package online.shop.binary.order;

import online.shop.binary.base.BaseService;
import online.shop.binary.warehouse.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService extends BaseService<Order, OrderRepository> {
	
	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Transactional
	public void checkout(Long cartId) {
		Order order = repository.findById(cartId)
		        .orElseThrow(() -> new RuntimeException("Order not found"));		
		for(OrderItem item:order.getItems()) {
			Warehouse warehouse = warehouseRepository
			        .findByProductId(item.getProduct().getId())
			        .orElseThrow(() -> new RuntimeException("Warehouse not found"));			
			if(warehouse.getQuantity() < item.getQuantity()) {
				throw new RuntimeException("Stock not enough");
			}
			
		warehouse.setQuantity(warehouse.getQuantity() - item.getQuantity());
		warehouseRepository.save(warehouse);
		}
		order.setStatus("confirmed");
		repository.save(order);
	}
	
}