package br.com.reserva;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TesteEntradaDatas {

	@Test
	void deveAceitarQualquerQuantidadeDatasMaiorQueZero() {
		EntradaDados e = new EntradaDados();
		ArrayList<String> entradas = new ArrayList<>();
		entradas.add("22/01/2018 23/01/2018 24/01/2018");
		entradas.add("22/01/2017");
		entradas.add("22/01/2016 22/03/2016 22/04/2016");
		for (int i = 0; i < entradas.size(); i++) {
			Scanner scan = new Scanner(entradas.get(i));
			e.datas(scan);
		}
		
	}
	
	@Test
	void deveAceitarSomenteStringFormatoData() {
		EntradaDados e = new EntradaDados();
		ArrayList<String> entradas = new ArrayList<>();
		entradas.add("o");
		entradas.add("22/01");
		entradas.add("22");
		entradas.add("85/88/88");
		for (int i = 0; i < entradas.size(); i++) {
			Scanner scan = new Scanner(entradas.get(i));
			e.datas(scan);
		}
	}
	
	@Test
	void deveSetarDatasCorretamente() {
		EntradaDados e = new EntradaDados();
		String s = "22/01/2018 23/01/2018 24/01/2018";
		Scanner scan = new Scanner(s);
		e.datas(scan);
		assertEquals(3, e.getDatas().size());
	}

}
