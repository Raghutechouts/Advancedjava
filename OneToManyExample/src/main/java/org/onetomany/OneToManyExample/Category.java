package org.onetomany.OneToManyExample;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	private int id;
	private String name;
	private List<ProductDetails> productDetails;
	
	
	public Category() {
	
	}
	public Category( String name) {
		super();
		this.id = id;
		this.name = name;
		this.productDetails = productDetails;
	}
	@Id
	@Column(name="Cat_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="categoryName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}
	
}
