package com.cg.lms.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class BooksIssued {
	
	@Id
	private int issueId;
	private Date issueDate;
	private int quantity;
	private Date dueDate;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "userId")
	private Users users;

	@ManyToMany
	@JoinTable(name="books_issued_books",
			   joinColumns= {@JoinColumn(name="issue_id")},
			   inverseJoinColumns= {@JoinColumn(name="book_id")})
	public List<Books> books = new ArrayList<>();

	public BooksIssued() {}

	public BooksIssued(int issueId, Date issueDate, int quantity, Date dueDate, Users users) {
		super();
		this.issueId = issueId;
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
		this.users = users;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<Books> getBooks() {
		return books;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "BooksIssued [issueId=" + issueId + ", issueDate=" + issueDate + ", quantity=" + quantity + ", dueDate="
				+ dueDate + "]";
	}

}
