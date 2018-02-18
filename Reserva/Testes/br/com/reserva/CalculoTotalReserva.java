package br.com.reserva;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculoTotalReserva {

	@Test
	void deveRetornarValoresCoerentes() {
		SouthCar sc = new SouthCar();
		double valor = sc.totalClienteRegular(5, 2);
		assertEquals(1450.0, valor, 0.00001);
		double valor1 = sc.totalClienteRegular(0, 0);
		assertEquals(0, valor1);
		double valor2 = sc.totalClienteRegular(2, 0);
		assertEquals(420.0, valor2);
	}

}
