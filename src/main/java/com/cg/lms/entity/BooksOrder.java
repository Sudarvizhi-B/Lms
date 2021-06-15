package com.cg.lms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BooksOrder {
	
	@Id
	private int orderId;
	private int quantity;
	@NonNull
	private String orderDate;
	@NonNull
	private String orderStatus;
	@NonNull
	private String publications;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="bookId")
	private Books books;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="publisher_id")
	public Publishers publisher;

	public BooksOrder(int orderId, int quantity, @NonNull String orderDate, @NonNull String orderStatus, Books books,
			Publishers publisher) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.books = books;
		this.publisher = publisher;
	}
}
