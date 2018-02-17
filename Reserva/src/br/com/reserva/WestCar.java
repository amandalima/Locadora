package br.com.reserva;

import java.util.ArrayList;

public class WestCar extends Locadora {
	
	public WestCar() {
		//Definição das taxas de cada tipo de cliente
		super.setClienteRegular(new Cliente(530.0, 200.0));
		super.setClienteFidelidade(new Cliente(150.0,90.0));
		
		//Adicionando 2 carros
		ArrayList<Carro> carros = new ArrayList<>();
		Carro c1 = new Esportivo();
		c1.setModelo("Ferrari");
		carros.add(c1);
		Carro c2 = new Esportivo();
		c2.setModelo("Jaguar");
		carros.add(c2);
		

		
	}

}