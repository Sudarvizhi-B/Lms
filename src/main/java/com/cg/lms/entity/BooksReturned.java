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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "BooksReturned")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BooksReturned {

	@Id
	private int id;
	@NonNull
	private LocalDate returnedDate;
	private int delayedDays;
	private double penalty;
	@NonNull
	private String penalty_Status;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users users;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="bookId")
	private Books books;
	
	public BooksReturned(int id, LocalDate returnedDate, int delayedDays, double penalty, String penalty_Status) {
		super();
		this.id = id;
		this.returnedDate = returnedDate;
		this.delayedDays = delayedDays;
		this.penalty = penalty;
		this.penalty_Status = penalty_Status;
	}

}
