package TUT_VZ_Session2;

public class WaehrungMethods {

	/**
	 * 	• erstellt ein Werte-Array der Länge 10.
		• befüllt es (eingabe())
		• liest den Faktor ein (Es wird solange nach einem Faktor gefragt, bis dieser größer als 0 ist.)
		• berechnet die Summe (summe()) und gibt diese aus
		• rechnet die Werte um (umrechnen())
		• berechnet die Summe der umgerechneten Werte (summe()) und gibt diese aus

	 * @param args
	 */
	public static void main(String[] args) {
		//erstellt ein Werte-Array der Länge 10.
		double[] werte = new double[10];
		// befüllt es (eingabe())
		eingabe(werte);
		//liest den Faktor ein (Es wird solange nach einem Faktor gefragt, bis dieser größer als 0 ist.)
		double faktor = getFaktor();
		//berechnet die Summe (summe()) 
		double summe = getSumme(werte);
		//und gibt diese aus
		printSum(summe);
		//rechnet die Werte um (umrechnen())
		umrechnen(werte, faktor);
		
		
	}

	private static void umrechnen(double[] werte, double faktor) {
		// TODO Auto-generated method stub
		
	}

	private static void printSum(double werte) {

		
	}

	private static double getSumme(double[] werte) {
		// TODO Auto-generated method stub
		return 0;
	}

	private static double getFaktor() {
		// TODO Auto-generated method stub
		return 0;
	}

	private static void eingabe(double[] werte) {
		// TODO Auto-generated method stub
		
	}

}
