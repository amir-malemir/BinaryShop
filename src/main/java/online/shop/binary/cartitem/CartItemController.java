package online.shop.binary.cartitem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import online.shop.binary.base.BaseController;

@RestController
@RequestMapping("/cart-item")
public class CartItemController extends BaseController<CartItem, CartItemService>{

}
