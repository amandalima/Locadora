package br.com.reserva;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class TesteEntradas {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private EntradaDados e = new EntradaDados();
	private Scanner scan;

	@Test
	void deveAceitarQualquerQuantidadeDatasMaiorQueZero() {
		
		ArrayList<String> entradas = new ArrayList<>();
		entradas.add("1:22/01/2018,23/01/2018");
		entradas.add("3:18/02/2018");
		for (int i = 0; i < entradas.size(); i++) {
			this.scan = new Scanner(entradas.get(i));
			this.e.entradas(scan);
		}
	}
	
	@Test
	void deveAceitarApenasDatasNoFormatoCerto() {
		exception.expect(Exception.class);
		String entrada="1:22/01,23/01/2018";
		this.scan = new Scanner(entrada);
		this.e.entradas(scan);
	}


}
