package br.com.reserva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class EntradaDados {

	private int passageiros;
	private ArrayList<Calendar> datas;

	// Exibe as mensagens para o usuário e guarda as entradas
	public void entradas() {
		// Obtém as datas
		this.datas();

		// Obtém a quantidade de passageiros no carro
		this.passageiros();
	}

	// Entrada para passageiros
	public void passageiros() {
		System.out.println("Quantos passageiros?");
		String s = "5";
		Scanner scan = new Scanner(s);
		// Scanner scan = new Scanner(System.in);
		this.setPassageiros(scan);
	}

	// Entrada para datas
	public void datas() {
		System.out.println("Informe as datas que deseja alugar o carro separadas por espaços");
		// Lê, valida e formata a entrada do teclado referente às datas
		String s = "18/02/2018 19/02/2018";
		Scanner scan = new Scanner(s);
		// Scanner scan = new Scanner(System.in);
		this.setDatas(scan.nextLine());
	}

	public int getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(Scanner passageiros) {

		// lê a entrada do teclado até encontrar um inteiro

		while (!passageiros.hasNextInt()) {
			System.out.println("Informe um número de passageiros");
			passageiros.next();
		}
		int num = passageiros.nextInt();
		if (num > 7) {
			System.out.println("Nenhum carro cabe mais de 7 passageiros!");
			passageiros.reset();
			this.passageiros();
		}
		passageiros.close(); // closing scanner
		this.passageiros = num;
	}

	public ArrayList<Calendar> getDatas() {
		return datas;
	}

	public void setDatas(String datas) {

		if (datas.isEmpty()) {
			this.datas();
		}
		try {
			String[] split = datas.split(" ");
			// percorre o array de string e transforma cada uma em data armazenando em um
			// arraylist
			ArrayList<Calendar> dates = new ArrayList<>();
			for (int i = 0; i < split.length; i++) {
				ManipulaDatas md = new ManipulaDatas();
				dates.add(md.transformaStringData(split[i]));
			}
			this.datas = dates;

		} catch (Exception e) {
			System.out.println("Informe as datas no padrão dd/mm/aaaa separadas por vírgula");
		}
	}

	// Procura o carro mais barato
	public void maisBarato() {

		// verifica quantas datas de semana e quantas de fim de semana o usuário
		// solicitou
		ManipulaDatas datas = new ManipulaDatas();
		int[] diasSemana = datas.converteDiasSemana(this.getDatas());

		@SuppressWarnings("unused")
		int semana = 0;
		@SuppressWarnings("unused")
		int fds = 0;
		for (int i = 0; i < diasSemana.length; i++) {
			if (diasSemana[i] == 7 || diasSemana[i] == 1) {
				fds++;
			} else {
				semana++;
			}
		}

		// verifica quais locadoras acomodam os passageiros
		ArrayList<Locadora> locadoras = new ArrayList<>();
		Locadora southCar = new SouthCar();
		if (southCar.getCapacidadeCarros() >= this.getPassageiros()) {
			locadoras.add(southCar);
		}
		Locadora nortCar = new NorthCar();
		if (nortCar.getCapacidadeCarros() >= this.getPassageiros()) {
			locadoras.add(nortCar);
		}
		Locadora westCar = new WestCar();
		if (westCar.getCapacidadeCarros() >= this.getPassageiros()) {
			locadoras.add(westCar);
		}
		System.out.println(this.getPassageiros());
		System.out.println(locadoras.size());

		Locadora melhorOpcao = locadoras.get(0);
		double valorReserva = melhorOpcao.totalClienteRegular(semana, fds);
		for (int i = 0; i < locadoras.size(); i++) {
			Locadora atual = locadoras.get(i);
			double valorAtual = atual.totalClienteRegular(semana, fds);
			double valorMelhor = melhorOpcao.totalClienteRegular(semana, fds);
			if (valorAtual < valorMelhor) {
				melhorOpcao = atual;
				valorReserva = valorAtual;
			}

		}
		melhorOpcao.listagemCarros(valorReserva);

	}

}
