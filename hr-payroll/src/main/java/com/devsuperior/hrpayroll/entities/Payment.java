package com.devsuperior.hrpayroll.entities;

import java.io.Serializable;

public class Payment implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private Double dailyIncoming;
	private Integer days;
	
	public Payment() {
		
	}

	public Payment(String name, Double dailyIncoming, Integer days) {
		if (days <= 0) {
			throw new IllegalArgumentException("Days must be greater than zero");
		}
		if (dailyIncoming <= 0.0) {
			throw new IllegalArgumentException("Daily income must be greater than zero");
		}
		this.name = name;
		this.dailyIncoming = dailyIncoming;
		this.days = days;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncoming() {
		return dailyIncoming;
	}

	public void setDailyIncoming(Double dailyIncoming) {
		this.dailyIncoming = dailyIncoming;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}
	
	public double getTotal() {
		return days * dailyIncoming;
	}

}
