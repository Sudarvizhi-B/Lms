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
	
}
