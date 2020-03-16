package edu.drexel.TrainDemo.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {
	
	public static String calculateDuration(String arrivalTime, String departureTime) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(departureTime);
		Date date2 = format.parse(arrivalTime);
		
		Date date = new Date(date1.getTime() - date2.getTime());
		SimpleDateFormat formatter= new SimpleDateFormat("HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		return formatter.format(date );
	}

}
