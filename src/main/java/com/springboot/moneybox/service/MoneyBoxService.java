package com.springboot.moneybox.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.moneybox.model.MoneyBox;

@Service
public class MoneyBoxService {

	@Autowired
	MoneyBox moneybox;
	
	/* Denominaciones permitidas */
	public List<Integer> availableDenominations() {
		return Arrays.asList(50,100,200,500,1000);
	}
	
	/* Introduce una moneda válida en la alcancía. */
	public boolean addCoin(int coin) {
		if (validateDenominations(coin)) {
			moneybox.setCoins(coin);
			return true;
		}
		return false;
	}
		
	/* Valida si el valor ingresado es una denominación válida permitida */
	public boolean validateDenominations(int denomination) {
		return availableDenominations().contains(denomination);
	}


	/* Calcula el total de dinero contenido en la alcancía */
	public int sumMoney() {
		return moneybox.getCoins().stream().mapToInt(m -> m.getDenomination()).sum();
	}

	/* Calcula el total de monedas en la alcancía. */
	public int sumCoins() {
		return moneybox.getCoins().size()-1;
	}

	
	/* Devuelve el total en dinero por denominación */
	public Integer sumByDenomination(Integer denomination) {		
		return moneybox.getCoins().stream().filter(moneda -> moneda.getDenomination()==denomination).mapToInt(m -> m.getDenomination()).sum();
	}

	/* Número total de monedas por denominación */
	public int coinsByDenomination(int denomination) {
		return (int) moneybox.getCoins().stream().filter(moneda -> moneda.getDenomination()==denomination).mapToInt(m -> m.getDenomination()).count();
	}
	
	public String showName() {
		return moneybox.getName();
	}
}
	
