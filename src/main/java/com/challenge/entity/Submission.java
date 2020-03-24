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
public class Submission {
	
	@EmbeddedId
	private SubmissionId identity;
	
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@MapsId("challenge_id")
	@JoinColumn(name = "challenge_id")
	private Challenge challenge;
	
	@NotNull
	private float score;
	
	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	public SubmissionId getIdentity() {
		return identity;
	}

	public void setIdentity(SubmissionId identity) {
		this.identity = identity;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	

}
