package br.com.reserva;

import java.util.Scanner;

public class Reserva {

	public static void main(String[] args) {

		// Obtém as entradas do usuário
		EntradaDados in = new EntradaDados();
		Scanner scan = new Scanner(System.in);
		// entradas de data
		in.datas(scan);
		
		//Entradas de passageiro
		in.passageiros(scan);

		// calcula o carro mais barato
		in.maisBarato();

	}

}
