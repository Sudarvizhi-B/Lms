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
	@NotBlank
	private int bookId;
	@NonNull
	@NotBlank
	private String title;
	@NonNull
	@NotBlank
	private String subject;
	@NonNull
	@NotBlank
	private String author;
	@NotBlank
	private int publishedYear;
	@NonNull
	@NotBlank
	private String isbnCode;
	@NotBlank
	private int quantity;
	@NotBlank
	private double bookCost;
	@NonNull
	@NotBlank
	private String shelfDetails;
	
}
