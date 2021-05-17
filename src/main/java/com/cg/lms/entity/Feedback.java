package com.cg.lms.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.NonNull;



@Entity
@Inheritance
@Getter
@Setter
@NoArgsConstructor
public class Feedback {

	@Id
	private int id;
	@NonNull
	private Date feedbackDate;
	@NonNull
	private String description;
	@NonNull
	private String rating;
	@NonNull
	private String comments;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users users;



	public Feedback(int id, Date feedbackDate, String description, String rating, String comments) {

		this.id = id;
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
	}

}
