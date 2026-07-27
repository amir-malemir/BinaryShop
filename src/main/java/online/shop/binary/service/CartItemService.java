package online.shop.binary.service;

import org.springframework.stereotype.Service;

import online.shop.binary.cartitem.CartItem;
import online.shop.binary.cartitem.CartItemRepository;

@Service
public class CartItemService extends BaseService<CartItem, CartItemRepository> {
}