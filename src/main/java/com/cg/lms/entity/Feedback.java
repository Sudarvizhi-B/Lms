package com.cg.lms.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.NonNull;



@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Feedback {

	@Id
	@GeneratedValue
	private int id;
	@NonNull
	private Date feedbackDate;
	@NonNull
	private String description;
	@NonNull
	private String rating;
	@NonNull
	private String comments;
	@NonNull
	private String userId;

	/*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Users users;*/



	public Feedback(Date feedbackDate, String description, String rating, String comments ,String userId ) {
		this.feedbackDate = feedbackDate;
		this.description = description;
		this.rating = rating;
		this.comments = comments;
		this.userId=userId;
	}

}
