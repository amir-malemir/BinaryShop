package online.shop.binary.cart;

import online.shop.binary.base.BaseController;
import online.shop.binary.service.CartService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController extends BaseController<Cart, CartService> {
}
