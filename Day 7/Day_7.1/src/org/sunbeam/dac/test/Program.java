package org.sunbeam.dac.test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Program 
{
	public static void main(String[] args) 
	{
		Date date = new Date(119, 3, 18);
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String str = sdf.format(date);
		System.out.println(str);
	}
	public static void main2(String[] args) 
	{
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DATE);
		int month = c.get(Calendar.MONTH) + 1;
		int year = c.get(Calendar.YEAR);
	}
	public static void main1(String[] args) 
	{
		LocalDateTime ldt = LocalDateTime.now();
		int day = ldt.getDayOfMonth();
		int month = ldt.getMonthValue();
		int year = ldt.getYear();
	}
}
