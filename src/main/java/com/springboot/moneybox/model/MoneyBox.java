package com.springboot.moneybox.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MoneyBox {

	@Autowired
	List<Coin> coins = new ArrayList<Coin>();
	String name = "ZABUD";

	public MoneyBox() {
	}

	public List<Coin> getCoins() {
		return coins;
	}

	public void setCoins(int moneda) {		
		this.coins.add(new Coin(moneda));
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}