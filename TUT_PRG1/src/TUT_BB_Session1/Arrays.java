package TUT_BB_Session1;

import Utils.TextIO;

public class Arrays {

	public static void main(String[] args) {

		int[] myIntArray = new int[10];
		Greet(1);
		fillArray(myIntArray);
		print(myIntArray, 7);
		Greet(2);
		

	}

	public static void Greet(int option) {
		switch(option) {
		case 1:
			TextIO.put("Hi\n");
			break;
		case 2:
			TextIO.put("Bye\n");
			break;
		default:
			TextIO.put("Fuck u");
		}
		
	}

	private static void fillArray(int[] array) {
		
		for(int i = 0; i < array.length; ) {
			array[i] = i++;
			
		}
		
	}

	private static void print(int[] array, int exit) {
		
		for(int tempIntValue:  array) {
			TextIO.putln(tempIntValue);
			
			
			if(tempIntValue == exit) {
				break;
			}
			
			
			
			
		}
	}





}
