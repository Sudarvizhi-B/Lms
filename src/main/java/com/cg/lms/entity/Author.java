package com.cg.lms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	
	@Id
	private int authorId;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="book_id")
	public List<Books> books = new ArrayList<>();
	
	private String firstName;
	private String lastName;
	private String email;
	private String contactno;
	
	
	public Author(){}
	public Author(int authorId, String firstName, String lastName, String email, String contactno) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactno = contactno;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public List<Books> getBooks() {
		return books;
	}
	public void setBooks(List<Books> books) {
		this.books = books;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", contactno=" + contactno + "]";
	}
	
}

