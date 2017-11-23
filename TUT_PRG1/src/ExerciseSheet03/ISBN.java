package ExerciseSheet03;

import Utils.TextIO;

public class ISBN {

	public static void main(String[] args) {

		TextIO.put("enter ISBN: ");
		String isbn = TextIO.getln();
		TextIO.putf("valid pattern: %s\n", validatePattern(isbn));
		TextIO.putf("valid checkDigit: %s\n", validateCheckDigit(isbn));

	}

	static boolean validatePattern(String s) {
		return s.matches("[0-9]{13}");
	}

	static boolean validateCheckDigit(String s) {
		// check if pattern is ok
		if (!validatePattern(s))
			return false;

		// convert string to array
		String[] S = s.split("");
		int innerSum = 0;

		// calculate innerSum
		for (int i = 0; i < S.length - 2; i++) {
			// parse each string index into an int to get the inner sum
			int x = Integer.parseInt(S[i]);

			if (i == 1) {
				innerSum += 3 * x;
				continue;
			} else if (i == 13) {
				innerSum += 3 * x;
				continue;
			} else
				innerSum += x;
		}

		// check the formula
		int x13 = Integer.parseInt(S[12]);
		if (x13 == ((10 - innerSum % 10) % 10))
			return true;
		else
			return false;
	}

}
