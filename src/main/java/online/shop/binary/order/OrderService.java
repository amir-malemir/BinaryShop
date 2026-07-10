package online.shop.binary.order;

import online.shop.binary.base.BaseService;
import online.shop.binary.warehouse.Warehouse;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService extends BaseService<Order, OrderRepository> {
	
	
	@Transactional
	public void checkout(Long cartId) {
		Order order = orderRepository.findbyId(cartId);
		
		for(OrderItem item:order.getItems()) {
			Warehouse warehouse = warehouseRepository.findByProduct(item.getProduct());
			
			if(warehouse.getQuantity() < item.getQuantity()) {
				throw new RuntimeException("Stock not enough");
			}
			
		warehouse.setQuantity(warehouse.getQuantity() - item.getQuantity());
		warehouseRepository.save(warehouse);
		}
		order.setStatus("confirmed");
		orderRepository.save(order);
	}
	
}