package online.shop.binary.order;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.shop.binary.base.BaseController;

@RestController
@RequestMapping("/order-item")
public class OrderItemController extends BaseController<OrderItem, OrderItemService> {
}
