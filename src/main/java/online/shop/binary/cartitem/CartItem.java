package online.shop.binary.cartitem;

import javax.persistence.*;

import online.shop.binary.base.BaseEntity;
import online.shop.binary.cart.Cart;
import online.shop.binary.products.Products;


@Entity
@Table(name = "cart_item")
public class CartItem extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Products product;
	
	@Column(nullable = false)
	private Integer quantity;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}
	
	

}
