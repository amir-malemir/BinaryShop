package online.shop.binary.service;

import online.shop.binary.order.Order;

public interface OrderService  extends BaseService<Order>{
	void checkout(Long userId, Long cartId);
}

