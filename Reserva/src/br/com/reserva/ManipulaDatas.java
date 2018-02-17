package br.com.reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	

}
