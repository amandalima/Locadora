package br.com.reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ManipulaDatas {
	private Scanner scan;

	public ManipulaDatas(Scanner scan) {
		this.scan = scan;
	}

	public ManipulaDatas() {

	}

	// transforma uma string em uma data do tipo calendar
	public Calendar transformaStringData(String data, Scanner scan) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(data));
		} catch (ParseException e) {
			System.out.println("As datas devem estar no padrão dd/mm/aaaa separadas por vírgula");
			EntradaDados en = new EntradaDados();
			en.datas(scan);
		}
		return cal;
	}

	// Converte datas do tipo calendar para um array de dias da semana
	public int[] converteDiasSemana(ArrayList<Calendar> datas) {
		int[] diasSemana = new int[datas.size()];
		for (int i = 0; i < datas.size(); i++) {
			Calendar date = datas.get(i);
			diasSemana[i] = date.get(Calendar.DAY_OF_WEEK);
		}

		return diasSemana;
	}

}
