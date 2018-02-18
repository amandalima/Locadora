package br.com.reserva;

public class Cliente extends Taxa {

	public Cliente(double taxaSemana, double taxaFimSemana) {
		super.setTaxaSemana(taxaSemana);
		super.setTaxaFimSemana(taxaFimSemana);
	}

}
