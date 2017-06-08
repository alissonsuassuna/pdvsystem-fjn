package br.com.fjn.pdv.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.Converter;

@Convert(Date.class)
public class DateConverter implements Converter<Date>{

	@Override
	public Date convert(String arg0, Class<? extends Date> arg1) {
		System.out.println(arg0);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date  = null;
		try {
			date = sdf.parse(arg0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

}
