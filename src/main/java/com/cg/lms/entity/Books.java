package com.cg.lms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Books {
	
	@Id
	private int bookId;
	@NonNull
	private String title;
	@NonNull
	private String subject;
	@NonNull
	private String author;
	private int publishedYear;
	@NonNull
	private String isbnCode;
	private int quantity;
	private double bookCost;
	@NonNull
	private String shelfDetails;
	private String imageName;
	
	public Books(int bookId, @NonNull String title, @NonNull String subject, @NonNull String author, int publishedYear,
			@NonNull String isbnCode, int quantity, double bookCost, @NonNull String shelfDetails) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publishedYear = publishedYear;
		this.isbnCode = isbnCode;
		this.quantity = quantity;
		this.bookCost = bookCost;
		this.shelfDetails = shelfDetails;
	}
	
}
