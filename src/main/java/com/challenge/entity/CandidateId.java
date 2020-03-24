package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CandidateId implements Serializable {
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Acceleration acceleration;
	
	@ManyToOne
	private Company company;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceleration == null) ? 0 : acceleration.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
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
		CandidateId other = (CandidateId) obj;
		if (acceleration != other.acceleration)
			return false;
		if (company != other.company)
			return false;
		if (user != other.user)
			return false;
		return true;
	}
	
	
}
