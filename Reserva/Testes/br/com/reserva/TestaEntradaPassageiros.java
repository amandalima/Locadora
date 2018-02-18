package br.com.reserva;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class TestaEntradaPassageiros {

	@Test
	
	void deveSetarCorretamentePassageiros() {
	
		EntradaDados e = new EntradaDados();
		Scanner scan = new Scanner("1");
		e.passageiros(scan);
		assertEquals(1, e.getPassageiros());
	}

}
