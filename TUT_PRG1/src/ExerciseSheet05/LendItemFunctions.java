package ExerciseSheet05;

import Utils.TextIO;

public class LendItemFunctions {

	public static String lendItemString(LendItem it, int format) {
		String lendItemString;

		switch (format) {
		case 1:
			lendItemString = String.format("%-15.15s %-10.10s %4d.%02d.%02d %4d.%02d.%02d %-10.10s", it.description,
					it.lender, it.lendDate.year, it.lendDate.month, it.lendDate.day, it.returnDate.year,
					it.returnDate.month, it.returnDate.day, it.owner);
			break;
		case 2:
			lendItemString = String.format("%-15.15s %-10.10s", it.description, it.lender);
			break;
		default:
			lendItemString = String.format("\"%s\",\"%s\",\"%4d.%02d.%02d\",\"%4d.%02d.%02d\",\"%s\"", it.description,
					it.lender, it.lendDate.year, it.lendDate.month, it.lendDate.day, it.returnDate.year,
					it.returnDate.month, it.returnDate.day, it.owner);
		}

		return lendItemString;

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

	// public static LendItem scanLendItem() {
	// LendItem it = new LendItem();
	//
	// do {
	// TextIO.putf("decription: ");
	// it.description = TextIO.getlnString();
	// if (it.description.length() == 0) {
	// TextIO.putf("description cannot be empty!.\n");
	// continue;
	// }
	// TextIO.putf("lender: ");
	// it.lender = TextIO.getlnString();
	// if (it.lender.length() == 0) {
	// TextIO.putf("lender cannot be empty!.\n");
	// continue;
	// }
	// TextIO.putf("owner: ");
	// it.owner = TextIO.getlnString();
	// break;
	//
	// } while (true);
	//
	// it.lendDate = scanDate();
	//
	// return it;
	// }

	public static Date scanDate() {
		Date newDate = new Date();

		Boolean validDate = false;

		do {
			TextIO.putf("year: ");
			newDate.year = TextIO.getlnInt();
			TextIO.putf("month: ");
			newDate.month = TextIO.getlnInt();
			TextIO.putf("day: ");
			newDate.day = TextIO.getlnInt();

			validDate = newDate.year > 1581 && newDate.month > 0 && newDate.month < 13 && newDate.day > 0
					&& newDate.day < 32;

			if (!validDate)
				TextIO.putf("invalid Date. reenter\n");
		} while (!validDate);

		return newDate;

	}

	public static int compare(LendItem it1, LendItem it2, int method) {

		int result;
		switch (method) {
		case 1:
			return result = compareByLendDate(it1, it2);
		case 2:
			return result = compareByReturnDate(it1, it2);
		case 3:
			return result = compareByLender(it1, it2);
		case 4:
			return result = compareByOwner(it1, it2);
		default:
			return result = compareByDescription(it1, it2);
		}
	}

	public static int compareByDescription(LendItem it1, LendItem it2) {

		Boolean it1isNull = false;
		Boolean it2isNull = false;

		if (it1.description.length() == 0)
			it1isNull = true;
		if (it2.description.length() == 0)
			it2isNull = true;
		if (it1isNull && it2isNull)
			return 0;
		if (!it1isNull && it2isNull)
			return 1;
		if (it1isNull && !it2isNull)
			return -1;
		int tmp = it1.description.compareTo(it2.description);

		if (tmp > 0)
			return 1;
		else if (tmp < 0)
			return -1;
		else
			return 0;
	}

	public static int compareByOwner(LendItem it1, LendItem it2) {

		Boolean it1isNull = false;
		Boolean it2isNull = false;

		if (it1.owner.length() == 0)
			it1isNull = true;
		if (it2.owner.length() == 0)
			it2isNull = true;
		if (it1isNull && it2isNull)
			return 0;
		if (!it1isNull && it2isNull)
			return 1;
		if (it1isNull && !it2isNull)
			return -1;
		int tmp = it1.owner.compareTo(it2.owner);

		if (tmp > 0)
			return 1;
		else if (tmp < 0)
			return -1;
		else
			return 0;
	}

	public static int compareByLender(LendItem it1, LendItem it2) {
		Boolean it1isNull = false;
		Boolean it2isNull = false;

		if (it1.lender.length() == 0)
			it1isNull = true;
		if (it2.lender.length() == 0)
			it2isNull = true;
		if (it1isNull && it2isNull)
			return 0;
		if (!it1isNull && it2isNull)
			return 1;
		if (it1isNull && !it2isNull)
			return -1;
		int tmp = it1.lender.compareTo(it2.lender);

		if (tmp > 0)
			return 1;
		else if (tmp < 0)
			return -1;
		else
			return 0;
	}

	public static int compare(Date d1, Date d2) {

		if (d1 == null && d2 == null)
			return 0;
		if (d1 == null)
			return -1;
		if (d2 == null)
			return 1;

		int it1Date = (d1.year * 100 + d1.month) * 100 + d1.day;
		int it2Date = (d2.year * 100 + d2.month) * 100 + d2.day;

		int tmp = Integer.compare(it1Date, it2Date);

		if (tmp > 0)
			return 1;
		else if (tmp < 0)
			return -1;
		else
			return 0;

	}

	public static int compareByReturnDate(LendItem it1, LendItem it2) {
		return compare(it1.returnDate, it2.returnDate);
	}

	public static int compareByLendDate(LendItem it1, LendItem it2) {
		return compare(it1.lendDate, it2.lendDate);
	}

	public static boolean equals(LendItem it1, LendItem it2) {
		if (equals(it1.lendDate, it2.lendDate) && equals(it1.returnDate, it2.returnDate)) {
			if (it1.description.equals(it2.description) && it1.lender.equals(it2.lender) && it1.owner.equals(it2.owner))
				return true;
		}

		return false;
	}

	public static boolean equals(Date d1, Date d2) {
		if (d1.year == d2.year && d1.month == d2.month && d1.day == d2.day)
			return true;
		else
			return false;
	}

	public static boolean isOut(LendItem li) {
		if (li.returnDate == null)
			return true;
		return false;
	}

}
