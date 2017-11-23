package ExerciseSheet02;

import Utils.TextIO;

public class Classifier {

	public static void main(String[] args) {

		int price, quality;

		TextIO.putf("enter price: ");
		price = TextIO.getInt();

		TextIO.putf("enter quality: ");
		quality = TextIO.getInt();

		if (price >= 50) {
			TextIO.putf("high price\n");
		} else {
			TextIO.putf("low price\n");
		}

		if (quality >= 50) {
			TextIO.putf("high quality\n");
		} else {
			TextIO.putf("low quality\n");
		}

		boolean junk, ripOff, bargain, luxury;

		junk = price < 50 && quality < 50;
		ripOff = price >= 50 && quality < 50;
		bargain = price < 50 && quality >= 50;
		luxury = price >= 50 && quality >= 50;

		if (junk) {
			TextIO.putf("junk\n");
		} else if (ripOff) {
			TextIO.putf("rip off\n");
		} else if (bargain) {
			TextIO.putf("bargain\n");
		} else if (luxury) {
			TextIO.putf("luxury\n");
		}

	}

}
