package com.challenge.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "name", length = 100)
	@NotNull
	@Size(min = 2, max = 100)
	private String name;
	
	@Column(name = "slug", length = 50)
	@NotNull
	@NotBlank
	@Size(max = 50)
	private String slug;
	
	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAd;
	
	@OneToMany
	private List<Candidate> candidates;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getCreatedAd() {
		return createdAd;
	}
	
	public List<Candidate> getCandidates() {
		return candidates;
	}
	
	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

}
