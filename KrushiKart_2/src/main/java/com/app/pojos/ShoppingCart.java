package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "carts")
@Getter
@Setter
@ToString(exclude = {"cartOwner","cartItems"})
public class ShoppingCart extends BaseEntity {

	@Column(name = "total_items")
	private int totalItems;
	
	@Column(name = "total_cart_price")
	private double totalCartPrice;
	
	@CreationTimestamp 
	@Column(name = "created_on")
	private LocalDate createdOn;
	
	@UpdateTimestamp 
	@Column(name = "last_updated_on")
	private LocalDate lastUpdatedOn;
	// Cart HAS-A Customer Cart ----> User
	// Cart : one , child , owning
	@JsonIgnore
	@OneToOne 
	@JoinColumn(name = "customer_id", nullable = false)
	private User cartOwner;
	// Cart *--->* Product	
	//Cart ---> CartItems : one to many
	@JsonIgnore
	@OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CartItem> cartItems=new ArrayList<>();
	
}
