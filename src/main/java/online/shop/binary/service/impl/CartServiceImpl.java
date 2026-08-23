package online.shop.binary.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import online.shop.binary.cart.Cart;
import online.shop.binary.cart.CartRepository;
import online.shop.binary.cartitem.CartItem;
import online.shop.binary.service.CartService;
import online.shop.binary.warehouse.Warehouse;
import online.shop.binary.warehouse.WarehouseRepository;

@Service
public class CartServiceImpl
        extends BaseServiceImpl<Cart, CartRepository>
        implements CartService {

    private final WarehouseRepository warehouseRepository;

    public CartServiceImpl(
            CartRepository repository,
            WarehouseRepository warehouseRepository) {

        super(repository);
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    @Transactional
    public void validateStock(Long cartId) {

        Cart cart = repository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        for (CartItem item : cart.getItems()) {

            Warehouse warehouse = warehouseRepository
                    .findByProductId(item.getProduct().getId())
                    .orElseThrow(() ->
                            new RuntimeException("Warehouse not found"));

            if (warehouse.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Stock not enough!");
            }
        }
    }
}