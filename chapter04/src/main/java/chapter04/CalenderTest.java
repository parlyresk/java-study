package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalenderTest {

	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();
//		
//		Locale aLocale=Locale.getDefault(Locale.Category.FORMAT);
//		TimeZone tz= TimeZone.getDefault();
//		System.out.println(aLocale);
		// System.out.println(tz);
		
		System.out.println(cal);
		
		printDate(cal);
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DATE,25);
		printDate(cal);
		
		cal.set(1998, 2,25);
		cal.add(Calendar.DATE, 10000);
		printDate(cal);
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"SUN","MON","TUE","WED","THR","FRI","SAT"};
		int year=cal.get(Calendar.YEAR);
		int month=cal.get(Calendar.MONTH); //0~11, +1
		int date=cal.get(Calendar.DATE);
		int day=cal.get(Calendar.DAY_OF_WEEK);
		int hour=cal.get(Calendar.HOUR_OF_DAY);
		int minute=cal.get(Calendar.MINUTE);
		int seconds=cal.get(Calendar.SECOND);
		
		System.out.println(
				(year)+"-"+
						(month+1)+"-"+
						date+" "+
						DAYS[day-1]+" "+
						hour+":"+
						minute+":"+
						seconds
				);
		
	}

}
