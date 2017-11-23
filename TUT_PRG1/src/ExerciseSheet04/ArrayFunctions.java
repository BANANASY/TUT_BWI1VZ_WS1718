package ExerciseSheet04;


public class ArrayFunctions {


	public static void main(String[] args) {
		
		

	}
	
	public static void linearFill(double[] array, double start, double inc) {

		if (array.length > 0) {
			array[0] = start;

			for (int i = 1; i < array.length; i++) {
				array[i] = array[i - 1] + inc;
			}
		}
	}



	public static String[] filter(String[] arr, String regex) {

		int filterLength = 0;

		for (String d : arr) {
			if (d.matches(regex)) {
				filterLength++;
			}
		}

		

		String[] matchs = new String[filterLength];

		filterLength = 0;

		for (String d: arr) {
			if (d.matches(regex)) {
				matchs[filterLength] = d;
				filterLength++;
			}
		}

		return matchs;
	}




	public static int find(int[] arr, int key, int startIdx) {

		if (startIdx >= 0) {
			int i = startIdx;

			for (; i < arr.length; i++) {
				if (key == arr[i]) {
					return i;
				}
			}

			return -1;
		} else
			return 0;
	}

	public static int find(int[] arr, int key) {

		for (int i = 0; i < arr.length; i++) {
			if (key == arr[i]) {
				return i;
			}
		}
		return -1;
	}

	public static int countBelow(double[] arr, double a) {

		int cnt = 0;

		for (int j = 0; j < arr.length; j++) {

			if (arr[j] < a) {
				cnt++;
			}
		}

		return cnt;
	}

	public static boolean contains(int[][] Array, int Key) {

		for (int i = 0; i < Array.length; i++) {
			for (int j = 0; j < Array[i].length; j++) {
				if (Key == Array[i][j]) {
					return true;
				}
			}
		}

		return false;
	}
}
