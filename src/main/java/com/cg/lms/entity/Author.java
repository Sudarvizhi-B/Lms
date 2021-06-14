package com.cg.lms.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "author")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Author {

	@Id
	//@NotEmpty
	private int authorId;
	@NonNull
	//@NotEmpty(message = "firstName cannot be Empty")
	private String firstName;
	@NonNull
	//@NotEmpty(message = "lastName cannot be Empty")
	private String lastName;
	@NonNull
	//@Email(message = "Email should be valid")
	private String email;
	@NonNull
	private String contactno;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "book_author", joinColumns = { @JoinColumn(name = "author_id") }, inverseJoinColumns = {
			@JoinColumn(name = "book_id") })
	private List<Books> books;

	public Author(int authorId, String firstName, String lastName, String email, String contactno) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contactno = contactno;
	}
}
