package TUT_Session1;

import Utils.TextIO;

public class Functions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printString("Enter your name: ",1);
		
		
		int b = 5;
		printString("Hello "+getString(),b);
		//do smth
		

	}

	public static String getString() {
		String userName = TextIO.getln();
		return userName;
	}

	public static void printString(String msg, int a) {
		int b;
		for(int i = 0;i<a;i++)
			TextIO.putln(msg);
		
	}

}
