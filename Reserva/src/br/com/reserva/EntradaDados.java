package br.com.reserva;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class EntradaDados {

	private int passageiros;
	private Scanner scan = new Scanner(System.in);
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
		this.setPassageiros(this.scan);
	}

	// Entrada para datas
	public void datas() {
		System.out.println("Informe as datas que deseja alugar o carro separadas por espaços");
		// Lê, valida e formata a entrada do teclado referente às datas
		this.setDatas(this.scan.nextLine());
	}

	public int getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(Scanner passageiros) {

		while(passageiros.hasNext()) {
			if (passageiros.hasNextInt()) {
				if(passageiros.nextInt() > 7) {
					System.out.println("Nenhum carro cabe mais de 7 passageiros!");
					passageiros.reset();
					this.passageiros();
				}
				this.passageiros = passageiros.nextInt();
			}else {
				System.out.println("Informe um número de passageiros");
				passageiros.reset();
				this.passageiros();
			}
		}	 

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

}
