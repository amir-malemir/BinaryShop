package online.shop.binary.service;

import org.springframework.stereotype.Service;

import online.shop.binary.order.OrderItem;
import online.shop.binary.order.OrderItemRepository;

@Service
public class OrderItemService extends BaseService<OrderItem, OrderItemRepository> {
}