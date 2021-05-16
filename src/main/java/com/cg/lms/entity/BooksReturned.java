package com.cg.lms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BooksReturned")
public class BooksReturned {

	@Id
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users users;
	
	//@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	//@JoinColumn(name = "book_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="book_id")
	private List<Books> books;
	
	private LocalDate returnedDate;
	private int delayedDays;
	private double penalty;
	private String penalty_Status;

	public BooksReturned() {}
	public BooksReturned(int id, LocalDate returnedDate, int delayedDays, double penalty, String penalty_Status) {
		super();
		this.id = id;
		this.returnedDate = returnedDate;
		this.delayedDays = delayedDays;
		this.penalty = penalty;
		this.penalty_Status = penalty_Status;
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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getReturnedDate() {
		return returnedDate;
	}

	public void setReturnedDate(LocalDate returnedDate) {
		this.returnedDate = returnedDate;
	}

	public int getDelayedDays() {
		return delayedDays;
	}

	public void setDelayedDays(int delayedDays) {
		this.delayedDays = delayedDays;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public String getPenalty_Status() {
		return penalty_Status;
	}

	public void setPenalty_Status(String penalty_Status) {
		this.penalty_Status = penalty_Status;
	}

	@Override
	public String toString() {
		return "BooksReturned [id=" + id + ", returnedDate=" + returnedDate + ", delayedDays=" + delayedDays
				+ ", penalty=" + penalty + ", penalty_Status=" + penalty_Status + "]";
	}

}
