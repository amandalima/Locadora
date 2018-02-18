package br.com.reserva;

import java.util.ArrayList;

public class SouthCar extends Locadora {

	public SouthCar() {
		super.setNome("SouthCar");
		// Definição das taxas de cada tipo de cliente
		super.setClienteRegular(new Cliente(210.0, 200.0));
		super.setClienteFidelidade(new Cliente(150.0, 90.0));

		// Definição da capacidade de passageiros
		super.setCapacidadeCarros(4);

		// Adicionando 2 carros
		ArrayList<Carro> carros = new ArrayList<>();
		Carro c1 = new Compacto();
		c1.setModelo("Gol");
		carros.add(c1);
		Carro c2 = new Compacto();
		c2.setModelo("Ka");
		carros.add(c2);
		super.setCarros(carros);
	}

}
