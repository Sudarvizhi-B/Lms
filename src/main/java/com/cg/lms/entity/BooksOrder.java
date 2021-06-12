package com.cg.lms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

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
	
	@OneToOne
	@JoinColumn(name="bookId")
	private Books books;
	
	@OneToOne
	@JoinColumn(name="publisher_id")
	public Publishers publisher;

}
