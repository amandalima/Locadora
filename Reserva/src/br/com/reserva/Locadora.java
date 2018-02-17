package br.com.reserva;

import java.util.ArrayList;

public abstract class Locadora {

	private Cliente clienteRegular;
	private Cliente clienteFidelidade;
	private ArrayList<Carro> carros;
	
	
	public Cliente getClienteRegular() {
		return clienteRegular;
	}
	public void setClienteRegular(Cliente clienteRegular) {
		this.clienteRegular = clienteRegular;
	}
	public Cliente getClienteFidelidade() {
		return clienteFidelidade;
	}
	public void setClienteFidelidade(Cliente clienteFidelidade) {
		this.clienteFidelidade = clienteFidelidade;
	}
	public ArrayList<Carro> getCarros() {
		return carros;
	}
	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}
	
	
}
