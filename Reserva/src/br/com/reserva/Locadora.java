package br.com.reserva;

import java.util.ArrayList;

public abstract class Locadora {

	private Cliente clienteRegular;
	private Cliente clienteFidelidade;
	private ArrayList<Carro> carros;
	private int capacidadeCarros;

	
	//Calcula o valor total do período de locação 
	//de acordo com a quantidade de dias da semanda e de final de semana
	//para um cliente regular
	public double totalClienteRegular(int diasSemana, int diasFds) {
		double totalFds = this.clienteRegular.getTaxaFimSemana() * diasFds;
		double totalSemana=this.clienteRegular.getTaxaSemana()* diasSemana;		
		return totalFds + totalSemana;
	}
	
	//Calcula o valor total do período de locação 
	//de acordo com a quantidade de dias da semanda e de final de semana
	//para um cliente fidelidade
	public double totalClienteFidelidade(int diasSemana, int diasFds) {
		double totalFds = this.clienteFidelidade.getTaxaFimSemana() * diasFds;
		double totalSemana=this.clienteFidelidade.getTaxaSemana()* diasSemana;		
		return totalFds + totalSemana;
	}
	
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
	public int getCapacidadeCarros() {
		return capacidadeCarros;
	}

	public void setCapacidadeCarros(int capacidadeCarros) {
		this.capacidadeCarros = capacidadeCarros;
	}

	public ArrayList<Carro> getCarros() {
		return carros;
	}
	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}
	
	
}
