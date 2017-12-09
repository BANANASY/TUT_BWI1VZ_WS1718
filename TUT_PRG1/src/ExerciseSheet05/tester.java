package ExerciseSheet05;

import Utils.TextIO;

public class tester {

	public static void main(String[] args) {

		LendItem book = new LendItem();

		book.description = "";
		book.lender = "Max";
		book.owner = "Moritz";

		Date lendDate = new Date();
		Date returnDate = new Date();

		lendDate.year = 2015;
		lendDate.month = 12;
		lendDate.day = 24;
		returnDate.year = 2016;
		returnDate.month = 12;
		returnDate.day = 24;

		book.lendDate = lendDate;
		book.returnDate = returnDate;

		LendItem dvd = new LendItem();

		dvd.description = "";
		dvd.lender = "Max";
		dvd.owner = "Moritz";

		Date lendDate2 = new Date();
		Date returnDate2 = new Date();

		lendDate2.year = 2016;
		lendDate2.month = 12;
		lendDate2.day = 24;
		returnDate2.year = 2016;
		returnDate2.month = 12;
		returnDate2.day = 24;

		dvd.lendDate = lendDate2;
		dvd.returnDate = returnDate2;

		TextIO.put(LendItemFunctions.compare(book, dvd, 2));
		TextIO.putln();

		TextIO.put(LendItemFunctions.equals(lendDate2, returnDate2));
		TextIO.putln();
		TextIO.put(LendItemFunctions.isOut(dvd));

	}

}
