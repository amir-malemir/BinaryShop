package online.shop.binary.service.impl;

import org.springframework.stereotype.Service;

import online.shop.binary.order.OrderItem;
import online.shop.binary.order.OrderItemRepository;
import online.shop.binary.service.OrderItemService;

@Service
public class OrderItemServiceImpl
        extends BaseServiceImpl<OrderItem, OrderItemRepository>
        implements OrderItemService {

    public OrderItemServiceImpl(OrderItemRepository repository) {
        super(repository);
    }
}