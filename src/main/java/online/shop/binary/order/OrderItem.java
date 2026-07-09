package online.shop.binary.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import online.shop.binary.base.BaseEntity;
import online.shop.binary.products.Products;
import javax.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;

    @Column(nullable = false)
    private Integer quantity;

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public Products getProduct() { return product; }
    public void setProduct(Products product) { this.product = product; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
