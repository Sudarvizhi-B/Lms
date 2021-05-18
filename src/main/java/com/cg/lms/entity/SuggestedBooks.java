package com.cg.lms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name="SuggestedBooks")
public class SuggestedBooks {
	
	@Id
	private int id;
	@NonNull
	private String title;
	@NonNull
	private String subject;
	@NonNull
	private String author;
	@NonNull
	private String publications;
	@NonNull
	private String description;
	@NonNull
	private LocalDate suggested_date;
	@NonNull
	private String status;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
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
