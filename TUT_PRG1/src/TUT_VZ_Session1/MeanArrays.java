package TUT_VZ_Session1;

import Utils.TextIO;

public class MeanArrays {

	public static void main(String[] args) {

		// Write a Program that reads at most 1024 integer numbers on the console and
		// stores them in an
		// array. Then the program computes and displays a series of statisstical
		// quantities.

		// Users are prompted for input once (in the beginning). All integer numbers are
		// accepted.
		// Input ends after the 1024th number or when zero is entered twice in a row.
		// After input of one
		// 0 users are asked whether to store value 0 or to exit with the following
		// message re-enter 0
		// to store as value.\nany other value ends input:. Another 0 is stored
		// (message: value 0
		// stored.), all other values end input (message: Input finished.)
		// If no numbers at all are stored, the program displays message no values
		// entered

		int[] input = new int[1024];
		int inputCnt = 0;
		
		for (int i = 0; i < input.length; i++) {
			TextIO.put(": ");
			int iNow = TextIO.getInt();
			if (iNow != 0) {
				input[i] = iNow;
				inputCnt++;
				continue;
			} else {
				TextIO.putln("re-enter 0 to store as value.\n" + "any other value ends input: ");
				iNow = TextIO.getInt();
				if (iNow == 0) {
					input[i] = iNow;
					inputCnt++;
				}
				else {
					break;
				}
			}
			
		}
		
		boolean noInput = false;
		if(inputCnt==0) {
			noInput = true;
		}
		
		if(noInput==true) {
			TextIO.putln("No input.");
		} else {
			int[] copyOfInput = copyArray(input, inputCnt);
			printArray(copyOfInput);
		}

		printArray(input, inputCnt);


	}
	
	private static void printArray(int[] toBePrinted) {
		printArray(toBePrinted,toBePrinted.length);
	}

	private static int[] copyArray(int[] input, int index) {
		int[] newArray = new int[index];
		for (int i = 0; i < index; i++) {
			newArray[i] = input[i];
		}
		return newArray;
	}

	public static void printArray(int[] toBePrinted, int index) {
		
		int i = 0;
		if(index==0) {
			return;
		}
		TextIO.putln("You entered:");
		for(int d: toBePrinted) {
			TextIO.putln(d);
			if(i==index-1) {
				break;
			}
			i++;
		}
//		TextIO.putln("You entered:");
//		for(int i=0; i<index;i++) {
//			TextIO.putln(toBePrinted[i]);
//		}
	}

}
