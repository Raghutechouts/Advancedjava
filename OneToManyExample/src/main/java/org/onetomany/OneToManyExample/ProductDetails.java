package org.onetomany.OneToManyExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "product_details_01")
public class ProductDetails {
	private int id;
	private String name;
	private String description;
	private float price;
	private Category category;
	
	
	public ProductDetails() {

	}
	public ProductDetails(String name, String description, float price, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}
	@Id
	@Column(name="Product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@ManyToOne
	@JoinColumn(name="Cat_id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
