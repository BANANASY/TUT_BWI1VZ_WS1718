package ExerciseSheet02;

import Utils.TextIO;

public class DateFormatConverter {

	public static void main(String[] args) {

		TextIO.putf("enter date (yyyymmdd)\n");

		int input;
		input = TextIO.getInt();

		if (input < 15821016 || input > 21001231) {
			TextIO.putf("invalid date\n");
		} else {
			
			int d, m, y, R;
			y = input / 10000;
			R = input % 10000;
			m = R / 100;
			d = R % 100;

			TextIO.putf("%02d.%02d.%02d", d, m, y);

		}

	}

}
