package br.com.reserva;

public class Cliente extends Taxa{
	
	private String tipo;
	
	public Cliente (double taxaSemana, double taxaFimSemana) {
		super.setTaxaSemana(taxaSemana);
		super.setTaxaFimSemana(taxaFimSemana);
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
