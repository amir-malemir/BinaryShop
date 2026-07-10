package online.shop.binary.cart;

import javax.persistence.Entity;

import java.util.List;
import javax.persistence.*;

import online.shop.binary.base.BaseEntity;
import online.shop.binary.users.User;
import online.shop.binary.cartitem.CartItem;


@Entity
@Table(name = "cart")
public class Cart extends BaseEntity {
	
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	
	@OneToMany(
		    mappedBy = "cart",
		    cascade = CascadeType.ALL,
		    orphanRemoval = true
		)
		private List<CartItem> items;
	
}
