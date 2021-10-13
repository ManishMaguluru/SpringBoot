package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="items")
public class Item {
	
	@Id
	@GeneratedValue
	private long icode;
	
	@NotNull
	@Column(name="itemName")
	private String itemName;
	
	@NotNull
	@Column(name="units")
	private String unit;
	
	@NotNull
	@Column(name="rate")
	private double rate;
	
	@NotNull
	@Column(name="category")
	private String category;
	
	public long getIcode() {
		return icode;
	}
	public void setIcode(long icode) {
		this.icode = icode;
	}
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public Item(long icode, String itemName, String unit, double rate, String category) {
		super();
		this.icode = icode;
		this.itemName = itemName;
		this.unit = unit;
		this.rate = rate;
		this.category = category;
	}
	public Item() {
		super();
	}
	
	

}
