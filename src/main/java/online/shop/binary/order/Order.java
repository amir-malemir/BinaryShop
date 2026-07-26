package online.shop.binary.order;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import online.shop.binary.base.BaseEntity;
import online.shop.binary.users.User;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public enum OrderStatus{
	PENDING,
	PAID,
	PROCESSING,
	CANCELLED
}

@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OrderStatus status = OrderStatus.PENDING;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Column(name = "order_date")
	private LocalDateTime orderDate = LocalDateTime.now();

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	private List<OrderItem> items = new ArrayList<>();

	public OrderStatus getStatus() { return status; }
	public void setStatus(OrderStatus status) { this.status = status; }

	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }

	public LocalDateTime getOrderDate() { return orderDate; }
	public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

	public List<OrderItem> getItems() { return items; }
	public void setItems(List<OrderItem> items) { this.items = items; }
}
