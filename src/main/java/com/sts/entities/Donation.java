package com.sts.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Donation")
public class Donation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Donation")
	@SequenceGenerator(name = "Donation", sequenceName = "mySeq",initialValue = 1)
	private int id;
	
	private String name;
	private String contact;
	private String email;
	private String txn_id;
	private String amount;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Donation() {
	}

	public Donation(int id, String name, String contact, String email, String txn_id, String amount, NGO ngo) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.txn_id = txn_id;
		this.amount = amount;
		this.ngo = ngo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTxn_id() {
		return txn_id;
	}

	public void setTxn_id(String txn_id) {
		this.txn_id = txn_id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public NGO getNgo() {
		return ngo;
	}

	public void setNgo(NGO ngo) {
		this.ngo = ngo;
	}
	@ManyToOne
	private NGO ngo;
}
