package com.cg.lms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="SuggestedBooks")
public class SuggestedBooks {
	
	@Id
	private int id;
	private String title;
	private String subject;
	private String author;
	private String publications;
	private String description;
	private LocalDate suggested_date;
	private String status;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
    private Users user;
	
	//constructors
	public SuggestedBooks() {}

	public SuggestedBooks(int id, String title, String subject, String author, String publications, String description,
			LocalDate suggested_date, String status) {
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
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublications() {
		return publications;
	}

	public void setPublications(String publications) {
		this.publications = publications;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getSuggested_date() {
		return suggested_date;
	}

	public void setSuggested_date(LocalDate suggested_date) {
		this.suggested_date = suggested_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	//to string
	@Override
	public String toString() {
		return "SuggestedBooks [id=" + id + ", title=" + title + ", subject=" + subject + ", author=" + author
				+ ", publications=" + publications + ", description=" + description + ", suggested_date="
				+ suggested_date + ", status=" + status + "]";
	}
	
}
