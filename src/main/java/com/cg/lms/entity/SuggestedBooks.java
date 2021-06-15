package com.cg.lms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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
@Table(name = "SuggestedBooks")
public class SuggestedBooks {

	@Id
	private int id;
	@NonNull
	//@NotEmpty(message="Title Should not be empty")
	private String title;
	@NonNull
	//@NotEmpty
	private String subject;
	@NonNull
	//@NotEmpty
	private String author;
	@NonNull
	//@NotEmpty
	private String publications;
	@NonNull
	//@NotEmpty
	private String description;
	@NonNull
	//@NotEmpty
	private LocalDate suggested_date;
	@NonNull
	//@NotEmpty
	//@Size(min = 10, max = 20)
	private String status;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users user;

	public SuggestedBooks(int id, @NonNull String title, @NonNull String subject, @NonNull String author,
			@NonNull String publications, @NonNull String description, @NonNull LocalDate suggested_date,
			@NonNull String status) {
		super();
		this.id = id;
		this.title = title;
		this.subject = subject;
		this.author = author;
		this.publications = publications;
		this.description = description;
		this.suggested_date = suggested_date;
		this.status = status;
	}

}