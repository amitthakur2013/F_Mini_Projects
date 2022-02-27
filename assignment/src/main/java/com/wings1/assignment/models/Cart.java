package com.wings1.assignment.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cart {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	private Double totalAmount;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "cart",fetch = FetchType.EAGER)
	private List<CartProduct> cartproducts;

	public Cart() {
		
	}

	public Cart(Integer cartId, Double totalAmount, User user, List<CartProduct> cartproducts) {
		super();
		this.cartId = cartId;
		this.totalAmount = totalAmount;
		this.user = user;
		this.cartproducts = cartproducts;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartProduct> getCartproducts() {
		return cartproducts;
	}

	public void setCartproducts(List<CartProduct> cartproducts) {
		this.cartproducts = cartproducts;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", totalAmount=" + totalAmount + ", user=" + user + ", cartproducts="
				+ cartproducts + "]";
	}

}
