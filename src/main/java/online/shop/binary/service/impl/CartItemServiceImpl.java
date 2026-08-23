package online.shop.binary.service.impl;

import org.springframework.stereotype.Service;

import online.shop.binary.cartitem.CartItem;
import online.shop.binary.cartitem.CartItemRepository;
import online.shop.binary.service.CartItemService;

@Service
public class CartItemServiceImpl
        extends BaseServiceImpl<CartItem, CartItemRepository>
        implements CartItemService {

    public CartItemServiceImpl(CartItemRepository repository) {
        super(repository);
    }
}