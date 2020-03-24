package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class SubmissionId implements Serializable {
	
	@ManyToOne
	@Column(name = "user_id")
	private User user;
	
	@ManyToOne
	@Column(name = "challenge_id")
	private Challenge challenge;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((challenge == null) ? 0 : challenge.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
