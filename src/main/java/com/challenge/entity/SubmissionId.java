package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SubmissionId implements Serializable {
	
	@Column(name = "user_id")
	private int user;
	
	@Column(name = "challenge_id")
	private int challenge;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + challenge;
		result = prime * result + user;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubmissionId other = (SubmissionId) obj;
		if (challenge != other.challenge)
			return false;
		if (user != other.user)
			return false;
		return true;
	}

	

}
