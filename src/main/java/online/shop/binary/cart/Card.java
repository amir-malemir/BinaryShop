package online.shop.binary.cart;

import javax.persistence.Entity;
import javax.persistence.Table;

import online.shop.binary.base.BaseEntity;

@Entity
@Table(name = "card")
public class Card extends BaseEntity {
	
	private String products;
	private String numbers;
	
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public String getNumbers() {
		return numbers;
	}
	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
}
