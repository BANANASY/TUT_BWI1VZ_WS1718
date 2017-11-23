package ExerciseSheet04;

import Utils.TextIO;

public class ArrayEvenStatistics {

	public static void main(String[] args) {

		TextIO.putf("Input\n");

		int[] input = new int[1025];

		int cntInput = 0, cntEvens = 0, sum = 0, max = Integer.MIN_VALUE;

		for (int i = 0; i < input.length; i++) {
			cntInput++;
			if (i < input.length-1) {
				TextIO.put(": ");
			}
			int tmp = TextIO.getInt();
			if (tmp != 0) {
				input[i] = tmp;
			} else if (tmp == 0) {
				TextIO.putf("re-enter 0 to store as value.\nany other value ends input: ");
				tmp = TextIO.getInt();
				if (tmp == 0) {
					input[i] = tmp;
					TextIO.putf("value 0 stored.\n");
				} else
					break;
			}

		}

		int[] evens = new int[cntInput - 1];

		for (int i = 0; i < cntInput - 1; i++) {
			if (input[i] % 2 == 0) {
				cntEvens++;
				sum += input[i];
				evens[i] = input[i];
			}
		}

		double mean = (double) sum / ((double) cntEvens);

		if (cntInput > 1) {
			TextIO.putf("Input finished.\n");
			TextIO.putf("          count: %d\n", cntEvens);
		} else {
			TextIO.putf("no values entered.\n");

		}

		if (cntEvens > 0) {
			TextIO.putf("index positions: [");
			for (int i = 0; i < cntInput - 1; i++) {
				if (input[i] % 2 == 0) {
					TextIO.putf(" %d", i);
				}
			}
			TextIO.putf("]\n");
			TextIO.putf("            sum: %d\n", sum);
			TextIO.putf("           mean: %.2f\n", mean);

			for (int i = 0; i < cntInput - 1; i++) {
				if (input[i] % 2 == 0) {
					if (input[i] > max)
						max = input[i];
				}
			}
			TextIO.putf("            max: %d [", max);
			for (int i = 0; i < cntInput - 1; i++) {
				if (input[i] == max) {
					TextIO.putf(" %d", i);
				}
			}

			TextIO.putf("]\n");
		}

	}
}