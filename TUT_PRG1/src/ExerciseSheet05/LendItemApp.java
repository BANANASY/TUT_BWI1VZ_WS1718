package ExerciseSheet05;


import Utils.TextIO;

public class LendItemApp {
	public static void main(String[] args) {
		LendItem it1 = new LendItem(), it2 = new LendItem();
		TextIO.putf("Welcome to LendApp\n");
		int mode = 0, format = 0;
		int input = 0;

		do {
			TextIO.putf("enter opcode (9 for usage): ");
			input = TextIO.getlnInt();
			switch (input) {
			case 0:
				it1 = LendItemFunctions.scanLendItem();
				break;
			case 1:
				it2 = LendItemFunctions.scanLendItem();
				break;
			case 2:
				TextIO.putf("%s\n", LendItemFunctions.lendItemString(it1, format));
				TextIO.putf("%s\n", LendItemFunctions.lendItemString(it2, format));
				break;
			case 4:
				TextIO.putf("set compare mode (" + "1=by lend date, " + "2=by return date, " + "3=by lender, "
						+ "4=by owner, " + "all other=by description: ");
				mode = TextIO.getInt();
			case 5:
				int cmp = LendItemFunctions.compare(it1, it2, mode);
				if (cmp < 0)
					TextIO.putf("LendItem1 is before LendItem2.\n");
				else if (cmp > 0)
					TextIO.putf("LendItem1 is after LendItem2.\n");
				else
					TextIO.putf("LendItems are equal.\n");
				break;
			case 6:
				TextIO.putf("LendItem1 and LendItem2 are %s equal.\n", LendItemFunctions.equals(it1, it2) ? "" : "not");
				break;
			case 9:
				TextIO.putf("1 enter LendItem1\n" + "2 enter LendItem2\n" + "3 printLendItem1\n" + "4 printLendItem2\n"
						+ "5 compare the LendItems\n" + "0 exit\n" + "9 display this message\n");
				break;
			default:
				TextIO.putln("invalid op code");
			case 666:
				break;
			}
		} while (input != 666);
		TextIO.putf("Thank you for using LendApp.\n");
	}

}