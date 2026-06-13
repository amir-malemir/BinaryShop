package online.shop.binary.order;

import online.shop.binary.base.BaseEntity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{
	private String status;
	
	public String getStatus() {return status;}
	public void setStatus(String status) {this.status = status;}

}
