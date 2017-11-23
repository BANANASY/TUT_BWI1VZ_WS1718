package ExerciseSheet04;

import Utils.TextIO;

public class ReadArray {

	public static void main(String[] args) {

		int[] myInts = new int[10];

		for (int i = 0; i < myInts.length; i++) {
			TextIO.putf("%d. number: ", i + 1);
			myInts[i] = TextIO.getInt();
		}

		TextIO.putf("Input finished.\n");

		for (int i = myInts.length - 1; i >= 0; i--) {
			TextIO.putf("[%d]: %d\n", i, myInts[i]);

		}
		
		
		TextIO.putf("Output finished.");

	}

}
