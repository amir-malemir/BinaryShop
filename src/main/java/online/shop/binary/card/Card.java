package online.shop.binary.card;

import javax.persistence.Entity;
import javax.persistence.Table;

import online.shop.binary.base.BaseEntity;

@Entity
@Table(name = "card")
public class Card extends BaseEntity {
	private String products;
	private String numbers;

}
