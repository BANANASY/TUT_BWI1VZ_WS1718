package ExerciseSheet04;

import Utils.TextIO;

public class ArrayMeanStatistics {

	public static void main(String[] args) {

		TextIO.putf("Input\n");

		int[] input = new int[1025];

		int cnt = 0, sum = 0, aboveMeanCnt = 0, min = Integer.MAX_VALUE;

		for (int i = 0; i < input.length; i++) {
			
			if (i < input.length - 1) {
				TextIO.put(": ");
			}
			int tmp = TextIO.getInt();
			if (tmp != 0) {
				input[i] = tmp;
				sum += input[i];
				cnt++;
			} else if (tmp == 0) {
				TextIO.putf("re-enter 0 to store as value.\nany other value ends input: ");
				tmp = TextIO.getInt();
				if (tmp == 0) {
					input[i] = tmp;
					TextIO.putf("value 0 stored.\n");
					cnt++;
					
				} else
					break;
			}

		}

		double mean = (double)sum / (cnt);

		if (cnt > 0) {
			TextIO.putf("Input finished.\n");
			TextIO.putf("total mean: %.2f\n----------\n", mean);
		} else {
			TextIO.putf("no values entered.\n");
		}

		int[] aboveMean = new int[cnt];
		sum = 0;

		for (int i = 0; i < cnt; i++) {
			if (input[i] > mean) {
				aboveMeanCnt++;
				sum += input[i];
				aboveMean[i] = input[i];
			}
		}
		if (aboveMeanCnt == 0 && cnt > 0) {
			TextIO.putf("          count: %d\n", aboveMeanCnt);
		}
		if (aboveMeanCnt > 0) {
			TextIO.putf("          count: %d\n", aboveMeanCnt);
			TextIO.putf("index positions: [");
			for (int i = 0; i < cnt; i++) {
				if (input[i] > mean) {
					TextIO.putf(" %d", i);
				}
			}
			TextIO.putf("]\n");
			TextIO.putf("            sum: %d\n", sum);
			TextIO.putf("           mean: %.2f\n", (double) sum / (double) aboveMeanCnt);

			for (int i = 0; i < cnt; i++) {
				if (input[i] > mean) {
					if (input[i] < min)
						min = input[i];
				}
			}
			TextIO.putf("            min: %d [", min);
			for (int i = 0; i < cnt; i++) {
				if (input[i] == min) {
					TextIO.putf(" %d", i);
				}
			}

			TextIO.putf("]\n");
		}

	}
}