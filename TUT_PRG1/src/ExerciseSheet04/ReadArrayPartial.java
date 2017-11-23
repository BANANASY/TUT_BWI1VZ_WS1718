package ExerciseSheet04;

import Utils.TextIO;

public class ReadArrayPartial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myInts = new int[10];
		int cnt = 0;

		for (int i = 0; i < myInts.length; i++) {

			int tmp = 0;

			do {
				TextIO.putf("%d. number: ", i + 1);
				tmp = TextIO.getInt();

				boolean negativeIntEntered = (tmp < 0);

				if (negativeIntEntered)
					TextIO.putf("invalid input!\n");
			} while (tmp < 0);

			if (tmp == 0)
				break;

			myInts[i] = tmp;
			cnt++;

		}

		TextIO.putf("%d numer(s) entered.\n", cnt);

		for (int i = 0; i < cnt; i++) {
			TextIO.putf("[%d]: %d\n", i, myInts[i]);

		}
		if (cnt > 0)
			TextIO.putf("Output finished.");

	}

}
