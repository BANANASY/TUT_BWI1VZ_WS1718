package ExerciseSheet02;

import Utils.TextIO;

public class NeatMultTable {

	public static void main(String[] args) {

		// input
		TextIO.putf("enter rows: ");
		int rows = TextIO.getInt();
		TextIO.putf("enter columns: ");
		int cols = TextIO.getInt();

		// heading line 1
		TextIO.putf("\n    ");
		for (int i = 1; i <= cols; i++) {
			TextIO.putf(" %2d", i);
		}
		TextIO.putf("\n");

		// heading line 2
		TextIO.putf("----");
		for (int i = 1; i <= cols; i++) {
			TextIO.putf("---");
		}
		TextIO.putf("\n");

		// table
		for (int i = 1; i <= rows; i++) {
			TextIO.putf(" %d |", i);
			for (int j = 1; j <= cols; j++) {
				TextIO.putf(" %2d", i * j);
			}
			if (i < rows) {
				TextIO.putf("\n");
			}
		}

	}

}
