package br.com.reserva;

import java.util.ArrayList;

public abstract class Locadora {

	private Cliente clienteRegular;
	private Cliente clienteFidelidade;
	private ArrayList<Carro> carros;
	private int capacidadeCarros;
	private String nome;

	// Exibe a as opções para o cliente
	public void listagemCarros(double valorReserva) {
		System.out.println("Locadora " + this.getNome());
		System.out.println("Carros disponíveis:");
		ArrayList<Carro> carros = this.getCarros();
		for (int i = 0; i < carros.size(); i++) {
			System.out.println("* " + carros.get(i).getModelo());
		}
		// formata o valor da reserva
		String resultado = String.format("%.2f", valorReserva);
		System.out.println("Valor total da reserva: R$" + resultado);

	}

	// Calcula o valor total do período de locação
	// de acordo com a quantidade de dias da semanda e de final de semana
	// para um cliente regular
	public double totalClienteRegular(int diasSemana, int diasFds) {
		double totalFds = this.clienteRegular.getTaxaFimSemana() * diasFds;
		double totalSemana = this.clienteRegular.getTaxaSemana() * diasSemana;
		return totalFds + totalSemana;
	}

	// Calcula o valor total do período de locação
	// de acordo com a quantidade de dias da semanda e de final de semana
	// para um cliente fidelidade
	public double totalClienteFidelidade(int diasSemana, int diasFds) {
		double totalFds = this.clienteFidelidade.getTaxaFimSemana() * diasFds;
		double totalSemana = this.clienteFidelidade.getTaxaSemana() * diasSemana;
		return totalFds + totalSemana;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
		return this.carros;
	}

	public void setCarros(ArrayList<Carro> carros) {
		this.carros = carros;
	}

}
