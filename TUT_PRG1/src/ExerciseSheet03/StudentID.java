package ExerciseSheet03;

import Utils.TextIO;

public class StudentID {
	
	public static void main(String[] args) {
		TextIO.put("enter studentID (wi**b***): ");
		String studID = TextIO.getln();
		TextIO.putf("ID valid: %s\n", validate(studID));
		TextIO.putf("graduation in: %d\n", graduation(studID));
		}
	
	public static boolean validate(String studID){
		return studID.matches("wi[0-9]{2}b[0-9]{3}");
	}
	
	public static int graduation(String studID){
		if (!validate(studID))
			return -1;
		int year = Integer.parseInt(studID.substring(2,4));
		return 2003+year;
	}


}
