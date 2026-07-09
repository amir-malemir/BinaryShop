package online.shop.binary.products;

import java.math.*;

import javax.persistence.*;
import online.shop.binary.base.BaseEntity;

@Entity
@Table(name = "products")
public class Products extends BaseEntity{
	
	private String name;
	private BigDecimal price;
	
	public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

}
