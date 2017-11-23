package ExerciseSheet02;

import Utils.TextIO;
import java.lang.Math.*;

public class TowerOfPower {

	public static void main(String[] args) {

		TextIO.putf("enter base:\n");
		int input = TextIO.getInt(), a;
		
		for (int i = 1;i != 8; i++) {
			a = (int)Math.pow((double)input, i);
			TextIO.putf("%8d\n", a);
		}

	}

}
