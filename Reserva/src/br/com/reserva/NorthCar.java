package br.com.reserva;

import java.util.ArrayList;

public class NorthCar extends Locadora {

	public NorthCar() {
		
		super.setNome("NorthCar");
		
		// Definição das taxas de cada tipo de cliente
		super.setClienteRegular(new Cliente(630.0, 600.0));
		super.setClienteFidelidade(new Cliente(580.0, 590.0));

		// Definição da capacidade de passageiros
		super.setCapacidadeCarros(7);

		// Adicionando 2 carros
		ArrayList<Carro> carros = new ArrayList<>();
		Carro c1 = new Suv();
		c1.setModelo("SW4");
		carros.add(c1);
		Carro c2 = new Suv();
		c2.setModelo("Duster");
		carros.add(c2);
		super.setCarros(carros);
		
	}
}
