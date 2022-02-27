package com.wings1.assignment.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	private String productName;

	private Double price;

	@ManyToOne
	@JoinColumn(name = "seller_id")
	@JsonIgnore
	private User seller;

	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonIgnore
	private Category category;
	
	@OneToOne(mappedBy = "product")
	@JsonIgnore
	private CartProduct cartProduct;

	public Product() {
	}

	public Product(Integer productId, String productName, Double price, User seller, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.seller = seller;
		this.category = category;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

	public CartProduct getCartProduct() {
		return cartProduct;
	}

	public void setCartProduct(CartProduct cartProduct) {
		this.cartProduct = cartProduct;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", seller="
				+ seller + ", category=" + category + "]";
	}

}
