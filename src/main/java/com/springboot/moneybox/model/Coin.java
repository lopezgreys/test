package com.springboot.moneybox.model;



import org.springframework.stereotype.Component;

@Component
public class Coin {
	
	int denomination;
	Integer year;
	
	public Coin() {		
	}
	
	public Coin(int Denomination) {
		setDenomination(Denomination);
	}
	
	public Coin(int Denomination, Integer Year) {
		setDenomination(Denomination);
		setYear(Year);
	}

	public int getDenomination() {
		return denomination;
	}

	public void setDenomination(int Denomination) {
		this.denomination = Denomination;
	}
	
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer Year) {
		this.year = Year;
	}

}
