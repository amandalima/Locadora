package br.com.reserva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class EntradaDados {

	private int passageiros;
	private ArrayList<Calendar> datas;
	private String[] splitDatas;

	public void entradas(Scanner scan) {
		System.out.println("Infome a entrada no formato <passageiros>:<dd/mm/yyyy>,<dd/mm/yyy>....");
		String entrada = scan.nextLine();
		try {
			String[] split = entrada.split(":");
			if(split.length != 2) {
				throw new Exception();
			}
			int numpassageiros = Integer.parseInt(split[0]);
			this.passageiros=numpassageiros;
			String[] splitDatas = split[1].split(",");
			if(splitDatas.length <1) {
				System.out.println("A segunda parte da entrada deve ser a lista das datas separadas por vírgula");
				System.out.println("Exemplo de entrada: 3:22/01/2018,23/01/2018");
				throw new Exception();
			}
			this.splitDatas=splitDatas;
		} catch (Exception e) {
		}
		
		// esperamos que a primeira entrada seja um inteiro maior que zero e menor que 8
		try {
			if (passageiros > 8 || passageiros < 1) {
				System.out.println("O número de passageiros deve estar entre 1 e 7."+
				" Não temos carros que comportam mais de 7 passageiros");
				throw new Exception();
			}
			this.setPassageiros(passageiros);
		} catch (Exception e) {
			System.out.println("A primeira parte da entrada deve ser o número de passageiros.");
			System.out.println("Exemplo de entrada: 3:22/01/2018,23/01/2018");
			this.entradas(scan);
		}
		// esperamos que a segunda parte da entrada sejam as datas
		try {
			
			ArrayList<Calendar> dates = new ArrayList<>();
			for (int i = 0; i < this.splitDatas.length; i++) {
				ManipulaDatas md = new ManipulaDatas();
				dates.add(md.transformaStringData(splitDatas[i], scan));
			}
			this.datas = dates;
		} catch (Exception e) {
			System.out.println("A segunda parte da entrada deve ser a lista das datas separadas por vírgula");
			System.out.println("Exemplo de entrada: 3:22/01/2018,23/01/2018");
		}

	}

	public int getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}

	public ArrayList<Calendar> getDatas() {
		return datas;
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

		// define quais locadoras tem o melhor valor
		double valorMelhor = 0.0;
		for (int i = 0; i < locadoras.size(); i++) {
			Locadora atual = locadoras.get(i);
			double valorAtual = atual.totalClienteRegular(semana, fds);
			if (valorMelhor == 0.0) {
				valorMelhor = valorAtual;
			}
			if (valorAtual > valorMelhor) {
				locadoras.remove(i);
			}
		}
		// Exibe saída para o usuário
		System.out.println("Melhores opções: ");
		for (int i = 0; i < locadoras.size(); i++) {
			locadoras.get(i).listagemCarros(valorMelhor);
		}

	}

}
