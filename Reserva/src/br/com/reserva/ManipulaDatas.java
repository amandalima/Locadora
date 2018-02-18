package br.com.reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ManipulaDatas {
	
	//transforma uma string em uma data do tipo calendar
	public Calendar transformaStringData(String data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(data));
		} catch (ParseException e) {
			System.out.println("Informe as datas no padrão dd/mm/aaaa separadas por vírgula");
			System.out.println();
			EntradaDados in = new EntradaDados();
			in.datas();
			
		}
		return cal;
	}
	
	//Converte datas do tipo calendar para um array de dias da semana
	public int[] converteDiasSemana(ArrayList<Calendar> datas) {
		int[] diasSemana = new int[datas.size()];
		for (int i = 0; i < datas.size(); i++) {
			Calendar date = datas.get(i);
			diasSemana[i]=date.get(Calendar.DAY_OF_WEEK);
		}
		
		return diasSemana;
	}
	

}
