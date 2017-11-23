package ExerciseSheet02;

import Utils.TextIO;

public class LeapChecker {

	public static void main(String[] args) {
		
		TextIO.putf("enter year:\n");
		int year = TextIO.getInt();
		
		boolean isLeap;
		
		if (year%400 == 0) {
			isLeap = true;
		} else if (year%100 == 0) {
			isLeap = false;
		} else if (year% 4 == 0) {
			isLeap = true;
		} else {
			isLeap = false;
		}
		
		
		if(!isLeap) {
			TextIO.putf("%d is/was not a leap year\n", year);
		} else {
			TextIO.putf("%d is/was a leap year\n", year);
		}

	}

}
