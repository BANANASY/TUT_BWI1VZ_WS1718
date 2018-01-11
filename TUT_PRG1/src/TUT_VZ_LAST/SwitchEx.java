package TUT_VZ_LAST;

import Utils.TextIO;

public class SwitchEx {

	public static void main(String[] args) {
		
		String weekday = "Thursday";
		
//		if(weekday.equals("Monday")) {
//			TextIO.putf("Today is Thursday");
//		} else if (weekday)
		
		switch(weekday) {
		case "Monday":
			TextIO.putf("Today is Monday");
			break;
		case "Tuesday":
			TextIO.putf("Today is Tuesday");
			break;
		case "Wedsnay":
			TextIO.putf("Today is Monday");
			break;
		case "Thursday":
			TextIO.putf("Today is Tuesday");
			break;
		default:
			TextIO.putf("Invalid day");
		}

	}

}
