package com.springboot.moneybox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.moneybox.service.MoneyBoxService;

@RestController
@RequestMapping("moneyboxzabud")
public class MoneyBoxController {

	@Autowired
	MoneyBoxService moneyBoxService;
	
	@GetMapping("index")
	public String initialMoneyBox() {
		 String URL = "localhost:8080/moneyboxzabud/";
		 String show = "<b><h1>Bienvenido a "+moneyBoxService.showName()+" MoneyBox</h1></b>";
		 show += "Denominaciones válidas: "+moneyBoxService.availableDenominations();
		 show += "<br>Total de monedas en la alcancía: "+moneyBoxService.sumCoins();
		 show += "<br>Total de dinero en la alcancía: $"+moneyBoxService.sumMoney();
		 show += "<br><br><h3>URL para ejecutar funciones</h3>"; 
		 show += "• Agregar moneda [POST]:<i> "+URL+"addcoin/DENOMINACION_AQUI</i>";
		 show += "<br>• Total de monedas: <i> "+URL+"coin/sum</i>";
		 show += "<br>• Total de dinero: <i> "+URL+"money/sum</i>";
		 show += "<br>• Total monedas por denominación: <i> "+URL+"coin/coinsbydenomination/DENOMINACION_AQUI</i>";
		 show += "<br>• Total dinero por denominación: <i> "+URL+"money/sumbydenomination/DENOMINACION_AQUI</i>";
		 return show;
	}
	
	@PostMapping("addcoin/{coin}")
	public String addCoin(@PathVariable("coin") Integer coin) {
		if (moneyBoxService.addCoin(coin)) return "Moneda agregada con éxito! =D";
		return "Denominación no es válida. =(";
	}

	@GetMapping("coin/sum")
	public String sumCoins() {
		return "En la alcancía hay un total de "+moneyBoxService.sumCoins()+" monedas.";
	}

	@GetMapping("coin/coinsbydenomination/{denomination}")
	public String coinsByDenomination(@PathVariable("denomination") Integer denomination) {
		return "En la alcancía hay "+moneyBoxService.coinsByDenomination(denomination)+" monedas de $"+denomination;
	}
	
	@GetMapping("money/sum")
	public String sumMoney() {
		return "En la alcancía hay un total de $"+moneyBoxService.sumMoney();
	}
	
	@GetMapping("money/sumbydenomination/{denomination}")
	public String sumByDenomination(@PathVariable("denomination") Integer denomination) {
		return "En la alcancía hay $"+moneyBoxService.sumByDenomination(denomination)+" en monedas de $"+denomination;
	}	
}
