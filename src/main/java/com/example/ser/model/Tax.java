package com.example.ser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="serv")
public class Tax {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="service_id")
private int id;
	@Column(name="Description")
private String description;
	@Column(name="QTY")
private int quantity;
    @Column(name="Unit_Price")
private int unitprice;
    @Column(name="Amount")
private int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		amount = quantity * unitprice;
		this.amount = amount;
	}
	
}