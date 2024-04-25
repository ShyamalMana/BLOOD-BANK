package com.shyam.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Blood_Group 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String bloog_group;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Doner> donor;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Buyer> buyer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBloog_group() {
		return bloog_group;
	}

	public void setBloog_group(String bloog_group) {
		this.bloog_group = bloog_group;
	}

	public List<Doner> getDonor() {
		return donor;
	}

	public void setDonor(List<Doner> donor) {
		this.donor = donor;
	}

	public List<Buyer> getBuyer() {
		return buyer;
	}

	public void setBuyer(List<Buyer> buyer) {
		this.buyer = buyer;
	}
	

}
