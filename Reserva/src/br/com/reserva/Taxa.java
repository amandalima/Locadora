package br.com.reserva;

public abstract class Taxa {

	private double taxaSemana;
	private double taxaFimSemana;

	public double getTaxaSemana() {
		return taxaSemana;
	}

	public void setTaxaSemana(double taxaSemana) {
		this.taxaSemana = taxaSemana;
	}

	public double getTaxaFimSemana() {
		return taxaFimSemana;
	}

	public void setTaxaFimSemana(double taxaFimSemana) {
		this.taxaFimSemana = taxaFimSemana;
	}

}
