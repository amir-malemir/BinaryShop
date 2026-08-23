package online.shop.binary.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import online.shop.binary.cart.Cart;
import online.shop.binary.cart.CartRepository;
import online.shop.binary.cart.CartStatus;
import online.shop.binary.cartitem.CartItem;
import online.shop.binary.order.Order;
import online.shop.binary.order.OrderItem;
import online.shop.binary.order.OrderRepository;
import online.shop.binary.order.OrderStatus;
import online.shop.binary.service.CartService;
import online.shop.binary.service.OrderService;
import online.shop.binary.warehouse.Warehouse;
import online.shop.binary.warehouse.WarehouseRepository;

@Service
public class OrderServiceImpl
        extends BaseServiceImpl<Order, OrderRepository>
        implements OrderService {

    private final WarehouseRepository warehouseRepository;
    private final CartRepository cartRepository;
    private final CartService cartService;

    public OrderServiceImpl(
            OrderRepository repository,
            WarehouseRepository warehouseRepository,
            CartRepository cartRepository,
            CartService cartService) {

        super(repository);
        this.warehouseRepository = warehouseRepository;
        this.cartRepository = cartRepository;
        this.cartService = cartService;
    }

    @Override
    @Transactional
    public void checkout(Long userId, Long cartId) {

        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        if (!cart.getUser().getId().equals(userId)) {
            throw new RuntimeException("Cart does not belong to this user!");
        }

        cartService.validateStock(cartId);

        Order order = new Order();

        order.setUser(cart.getUser());
        order.setOrderDate(LocalDateTime.now());
        order.setStatus(OrderStatus.PAID);

        for (CartItem cartItem : cart.getItems()) {

            Warehouse warehouse = warehouseRepository
                    .findByProductId(cartItem.getProduct().getId())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Warehouse not found for product: "
                                    + cartItem.getProduct().getId()));

            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(order);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());

            order.getItems().add(orderItem);

            warehouse.setQuantity(
                    warehouse.getQuantity() - cartItem.getQuantity());

            warehouseRepository.save(warehouse);
        }

        repository.save(order);

        cart.setStatus(CartStatus.CHECKED_OUT);
        cartRepository.save(cart);
    }
}