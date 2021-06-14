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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	//@NotEmpty
	private int id;
	@NonNull
	//@NotEmpty(message = "should be format yyyy-mm-dd")
	private LocalDate returnedDate;
	//@NotEmpty(message = "Delayed days should not be empty")
	private int delayedDays;
	//@NotEmpty
	private double penalty;
	@NonNull
	//@NotEmpty
	//@Size(min=3, max=15)
	private String penalty_Status;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users users;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "bookId")
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
