package online.shop.binary.cart;

import javax.persistence.Entity;
import javax.persistence.*;

import online.shop.binary.base.BaseEntity;
import online.shop.binary.users.User;

@Entity
@Table(name = "card")
public class Cart extends BaseEntity {
	
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	
	
}
