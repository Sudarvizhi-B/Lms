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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BooksIssued {

	@Id
	private int issueId;
	private Date issueDate;
	private int quantity;
	private Date dueDate;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private Users users;

	@ManyToMany
	@JoinTable(name = "books_issued_books", joinColumns = { @JoinColumn(name = "issue_id") }, inverseJoinColumns = {
			@JoinColumn(name = "book_id") })
	public List<Books> books = new ArrayList<>();

	public BooksIssued(int issueId, Date issueDate, int quantity, Date dueDate, Users users) {
		super();
		this.issueId = issueId;
		this.issueDate = issueDate;
		this.quantity = quantity;
		this.dueDate = dueDate;
		this.users = users;
	}

	@Override
	public String toString() {
		return "BooksIssued [issueId=" + issueId + ", issueDate=" + issueDate + ", quantity=" + quantity + ", dueDate="
				+ dueDate + ", users=" + users + "]";
	}
}
