package ExerciseSheet03;

import Utils.TextIO;

public class BMI {

	public static void main(String[] args) {

		double weight, height, bmi;

		TextIO.putf("weight [kg]: ");
		weight = TextIO.getlnDouble();

		TextIO.putf("height [m]: ");
		height = TextIO.getlnDouble();

		TextIO.putf("m=%.2fkg h=%.2fm -> BMI=%.2f (", weight, height, bmi = bmiCalc(height, weight));
		bmiMessage(bmiCategory(bmi));
		TextIO.putf(")\n");
	}

	public static double bmiCalc(double height, double weight) {

		double bmi = -1;
		if (height < 1.6 || weight < 40) {
			return bmi;
		} else {
			return bmi = weight / (height * height);
		}
	}

	public static int bmiCategory(double bmi) {

		if (bmi == -1) return -1;
		else if (bmi < 15.00) return 10;
		else if (bmi >= 15.00 && bmi < 16.00) return 11;
		else if (bmi >= 16.00 && bmi < 18.50) return 12;
		else if (bmi >= 18.50 && bmi < 25.00) return 20;
		else if (bmi >= 25.00 && bmi < 30.00) return 30;
		else if (bmi >= 30.00 && bmi < 35.00) return 40;
		else if (bmi >= 35.00 && bmi < 40.00) return 41;
		else if (bmi >= 40.00) return 42;
		else return -1;
	}

	public static void bmiMessage(int bmiCategory) {

		// if (bmiCategory == 10)
		// TextIO.put("Very severely underweight");
		// else if (bmiCategory == 11)
		// TextIO.put("Severely underweight");
		// else if (bmiCategory == 12)
		// TextIO.put("Underweight");
		// else if (bmiCategory == 20)
		// TextIO.put("Normal");
		// else if (bmiCategory == 30)
		// TextIO.put("Overweight");
		// else if (bmiCategory == 40)
		// TextIO.put("Moderately obese");
		// else if (bmiCategory == 41)
		// TextIO.put("Severely obese");
		// else if (bmiCategory == 42)
		// TextIO.put("Very severely obese");
		// else TextIO.put("invalid");

		switch (bmiCategory) {

		case -1:
			TextIO.put("invalid");
			break;
		case 10:
			TextIO.put("Very severely underweight");
			break;
		case 11:
			TextIO.put("Severely underweight");
			break;
		case 12:
			TextIO.put("Underweight");
			break;
		case 20:
			TextIO.put("Normal");
			break;
		case 30:
			TextIO.put("Overweight");
			break;
		case 40:
			TextIO.put("Moderately obese");
			break;
		case 41:
			TextIO.put("Severely obese");
			break;
		case 42:
			TextIO.put("Very severely obese");
			break;

		}
	}
}
