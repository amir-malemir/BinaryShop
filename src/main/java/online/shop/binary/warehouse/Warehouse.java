package online.shop.binary.warehouse;

import online.shop.binary.base.BaseEntity;
import online.shop.binary.products.Products;
import javax.persistence.*;

@Entity
@Table(name = "warehouse")
public class Warehouse extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false, unique = true	)
    private Products product;

    @Column(nullable = false)
    private Integer quantity = 0;

    public Products getProduct() { return product; }
    public void setProduct(Products product) { this.product = product; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
