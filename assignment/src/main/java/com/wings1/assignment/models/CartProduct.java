package com.wings1.assignment.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartProduct {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cpId;
	@ManyToOne
	@JoinColumn(name = "cart_id")
	@JsonIgnore
	private Cart cart;
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	private Integer quantity = 1;

	public CartProduct() {
		
	}

	public CartProduct(Cart cart, Product product, Integer quantity) {
		super();
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}

	public Integer getCpId() {
		return cpId;
	}

	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartProduct [cpId=" + cpId + ", cart=" + cart + ", product=" + product + ", quantity=" + quantity + "]";
	}

}
