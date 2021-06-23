package io.artcreativity.emarket.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String image;
	private Double price;
	private long stock;
	private long sold;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String name, String description, String image, double price, long stock, long sold) {
		super();
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.stock = stock;
		this.sold = sold;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public long getSold() {
		return sold;
	}
	public void setSold(long sold) {
		this.sold = sold;
	}
	
	
}
