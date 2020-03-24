package com.challenge.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Candidate {

	@EmbeddedId
	private CandidateId id;
	
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@MapsId("acceleration_id")
	@JoinColumn(name = "acceleration_id")
	private Acceleration acceleration;
	
	@ManyToOne
	@MapsId("company_id")
	@JoinColumn(name = "company_id")
	private Company company;
	
	@NotNull
	private int status;
	
	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	public CandidateId getIdentity() {
		return id;
	}

	public void setIdentity(CandidateId identity) {
		this.id = identity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	
}
