package Models;

import java.sql.Date;

public class myDate extends Date{
	public myDate(int year, int month, int day) {
		super(year-1900, month-1, day);
		// TODO Auto-generated constructor stub
	}
	public myDate(Date temp)
	{
		super(temp.getYear(), temp.getMonth(), temp.getDay());
	}
	
	public static int getNumberDateOfMonth(int month, int year)
	{
		int date = 31;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			date =31;
			break;
		case 2:
		{
			if( (year%4 == 0 && year%100 != 0) || year%400 == 0) date = 29;
			else date =28;
			break;
		}
		case 4:
		case 6:
		case 9:
		case 11:
			date = 30;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + month);
		}
		return date;
	}
}
