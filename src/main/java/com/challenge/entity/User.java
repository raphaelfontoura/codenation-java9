package com.challenge.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "full_name", length = 100)
	@NotNull
	@Size(min = 3, max = 100)
	private String fullName;
	
	@Column(name = "email", length = 100)
	@NotNull
	@Email
	@Size(max = 100)
	private String email;
	
	@Column(name = "nickname", length = 50)
	@NotNull
	@Size(min = 3, max = 50)
	private String nickname;
	
	@NotNull
	@NotBlank
	@Column(name = "password", length = 255)
	@Size(min = 3, max = 255)
	private String password;
	
	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Candidate> candidates;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Submission> submissions;
	
	public int getId() {
		return id;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public List<Candidate> getCandidates() {
		return candidates;
	}
	
	public List<Submission> getSubmissions() {
		return submissions;
	}
	
}
