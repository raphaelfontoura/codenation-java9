package com.challenge.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CandidateId implements Serializable {
	
	@Column(name = "user_id")
	private int user;
	
	@Column(name = "acceleration_id")
	private int acceleration;
	
	@Column(name = "company_id")
	private int company;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acceleration;
		result = prime * result + company;
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
