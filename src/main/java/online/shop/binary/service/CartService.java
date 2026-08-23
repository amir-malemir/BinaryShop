package online.shop.binary.service;

import online.shop.binary.cart.Cart;

public interface CartService extends BaseService<Cart> {

    void validateStock(Long cartId);
}