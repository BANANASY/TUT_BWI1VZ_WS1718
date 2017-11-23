package ExerciseSheet02;

import Utils.TextIO;

public class LoopStatistics {

	public static void main(String[] args) {

		TextIO.putf("enter numbers:\n");

		float input = TextIO.getInt(), sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, mean = 0;
		int i = 0;

		if (input > 0) {
			for (; input > 0; i++) {

				if (input > 0) {
					if (input < min) {
						min = input;
					}
					if (input > max) {
						max = input;
					}
					sum += input;
					mean = sum / (i + 1);
				}
				input = TextIO.getInt();
			}

			TextIO.putf("numbers entered: %d\nminimum: %.2f\nmaximum: %.2f\nmean:    %.2f\n", i, min, max, mean);
		} else {
			TextIO.putf("no number entered.\n");
		}

	}

}
