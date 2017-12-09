package ExerciseSheet05;

import Utils.TextIO;

public class Tester2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LendItem it = scanLendItem();

		printLendItem(it);

	}

	private static void printLendItem(LendItem it) {
		// TODO Auto-generated method stub
		TextIO.putln(it.description);
		TextIO.putln(it.lender);
		TextIO.putln(it.owner);
		TextIO.putf("%d.%d.%d", it.lendDate.year, it.lendDate.month, it.lendDate.day);
		// TextIO.putf("%d.%d.%d",it.returnDate.year, it.returnDate.month,
		// it.returnDate.day);

	}

	public static LendItem scanLendItem() {
		LendItem it = new LendItem();

		do {
			TextIO.putf("decription: ");
			it.description = TextIO.getlnString();
	
			TextIO.putf("lender: ");
			it.lender = TextIO.getlnString();

			TextIO.putf("owner: ");
			it.owner = TextIO.getlnString();

			if (it.lender.length() == 0 || it.description.length() == 0) {
				if (it.lender.length() == 0) {
					TextIO.putf("lender cannot be empty!.\n");
					continue;
				}
				if (it.description.length() == 0) {
					TextIO.putf("description cannot be empty!.\n");
					continue;
				}

			}
			break;

		} while (true);

		it.lendDate = LendItemFunctions.scanDate();

		return it;
	}
}
