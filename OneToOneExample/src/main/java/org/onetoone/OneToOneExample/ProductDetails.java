package org.onetoone.OneToOneExample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name="product_details_01")
public class ProductDetails {
	
	private int productId;
	private String productDescription;
	private String dimenctions;
	private int weight;
	private Product product;
	
	public ProductDetails() {
		
	}
	@Id
	@GeneratedValue(generator = "foreigngen")
	@GenericGenerator(strategy = "foreign", name="foreigngen",
				parameters=@Parameter(name="property",value = "product"))
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getDimenctions() {
		return dimenctions;
	}
	public void setDimenctions(String dimenctions) {
		this.dimenctions = dimenctions;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@OneToOne(mappedBy = "productDetails")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
