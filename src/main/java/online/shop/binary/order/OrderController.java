package online.shop.binary.order;

import online.shop.binary.base.BaseController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController<Order, OrderService> {
	
	@PostMapping("/checkout/{cartId}")
    public void checkout(@PathVariable Long cartId) {
        service.checkout(cartId);
    }
}
