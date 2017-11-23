package ExerciseSheet03;

import Utils.TextIO;

public class Weekdays {

	public static void main(String[] args) {
		TextIO.putln("enter date (yyyymmdd)");
		int date = TextIO.getInt();
		int inDay = date % 100, inMonth = date % 10000 / 100, inYear = date / 10000;
		if (validate(inYear, inMonth, inDay)) {
			int W = weekday(inDay, inMonth, inYear);
			String weekday = dayName(W);
			TextIO.putf("%02d.%02d.%4d was/is or will be a %s", date % 100, date % 10000 / 100, date / 10000, weekday);
		} else {
			TextIO.putf("invalid date (%d)\n", date);
		}
	}

	public static boolean validate(int year) {
		// returns whether the given year is in the accepted range or exists at
		// all
		// • returns true if year is valid, false otherwise
		// • the earliest valid date is Oct. 16th 1582, the last date accepted
		// is Dec, 31st, 2199
		boolean validYear = false;
		if (year >= 1582 && year <= 2199)
			validYear = true;
		return validYear;
	}

	public static boolean validate(int year, int month) {
		// • returns whether the given year and month combination actually
		// exists/existed and is in
		// the accepted range
		// • the earliest valid date is Oct. 16th 1582, the last date accepted
		// is Dec, 31st, 2199
		if (!validate(year))
			return false;
		else if (month < 1 || month > 12)
			return false;
		else
			return true;
	}

	public static boolean isLeap(int inYear) {
		boolean isLeap;

		if (inYear % 400 == 0) {
			isLeap = true;
		} else if (inYear % 100 == 0) {
			isLeap = false;
		} else if (inYear % 4 == 0) {
			isLeap = true;
		} else {
			isLeap = false;
		}
		return isLeap;
	}

	public static int nDays(int month, int year) {
		// returns the number of days in month of year
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;

		case 4:
		case 6:
		case 9:
		case 11:
			return 30;

		case 2:
			if (isLeap(year))
				return 29;
			else
				return 28;
		default:
			return -1;

		}

	}

	public static boolean validate(int year, int month, int day) {
		// • returns whether the given date actually exists/existed
		// • returns true if date is valid, false otherwise
		// • the earliest valid date is Oct. 16th 1582, the last date accepted
		// is Dec, 31st, 2199
		boolean valid = false;

		valid = validate(year, month);
		if (!valid)
			return false;

		else if (day <= 0 || day > nDays(month, year))
			return false;

		else if (year == 1582 && month < 10)
			return false;
		
		else if (year == 1582 && month == 10 && day < 16)
			return false;

		else if (year == 2199 && month > 12 && day > 31)
			return false;

		else
			return true;
	}

	public static int weekday(int inDay, int inMonth, int inYear) {

		if (inMonth == 1 || inMonth == 2) {
			inYear--;
			inMonth += 10;
		} else {
			inMonth -= 2;
		}

		int c = inYear / 100;
		int y = inYear % 100;

		int A = inDay + (int)(2.6 * inMonth - 0.2) + y + (int)(y / 4) + (int)(c / 4) - 2 * c;

		int W = A % 7;

		while (W < 0) {
			W += 7;
		}

		return W;

	}

	public static String dayName(int W) {

		switch (W) {
		case 0:
			return "Sunday";
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";

		default:
			return "";
		}

	}

}
