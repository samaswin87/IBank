package com.intec.ibank.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class CurrentDate.
 */
public class CurrentDate {
	
	/**
	 * Current date.
	 *
	 * @return the date
	 * @throws ParseException the parse exception
	 */
	public Date currentDate() throws ParseException
	{
		 String DATE_FORMAT_NOW = "dd-MM-yyyy HH:mm:ss";
			Calendar cal = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		    String date1 = sdf.format(cal.getTime());
		    Date date;
			
				date = (Date)sdf.parse(date1);
				return date;
		
	}
	public String currentDate1() throws ParseException
	{
		Calendar cal = Calendar.getInstance();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String date1 = sdf.format(cal.getTime());
			return date1;
		
	}

}
