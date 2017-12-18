package TUT_VZ_Session2;

import Utils.TextIO;

public class Waehrung {

	/**
	 * • erstellt ein Werte-Array der Länge 10. • befüllt es (eingabe()) • liest den
	 * Faktor ein (Es wird solange nach einem Faktor gefragt, bis dieser größer als
	 * 0 ist.) • berechnet die Summe (summe()) und gibt diese aus • rechnet die
	 * Werte um (umrechnen()) • berechnet die Summe der umgerechneten Werte
	 * (summe()) und gibt diese aus
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// erstellt ein Werte-Array der Länge 10.
		double[] betraege = new double[10];
		// befüllt es (eingabe())
		int anzahl = eingabe(betraege, betraege.length);
		// liest den Faktor ein (Es wird solange nach einem Faktor gefragt, bis dieser
		// größer als 0 ist.)
		double faktor = getFaktor();
		double vorher = summe(betraege, anzahl);
		// und gibt diese aus
		printValue(vorher, "vorher");
		umrechnen(betraege, anzahl, faktor);

	}

	private static void printValue(double betrag, String value) {
		TextIO.putf("Summe %s: %.2f\n", value, betrag);

	}

	private static double getFaktor() {
		TextIO.putf("Faktor: ");
		return TextIO.getDouble();
	}

	/**
	 * Die Funktion multipliziert die ersten anzahl Werte im array betraege mit
	 * faktor.
	 * 
	 * @param betraege
	 * @param anzahl
	 * @param faktor
	 */
	public static void umrechnen(double betraege[], int anzahl, double faktor) {
		double nachher = summe(betraege, anzahl)*faktor;
		printValue(nachher, "nachher");
	}

	/**
	 * Die Funktion erfragt höchstens max Werte, speichert diese im array betraege,
	 * bricht aber auch bei Eingabe einer negativen Zahl ab und liefert die Anzahl
	 * der eingegebenen Werte zurück.
	 * 
	 * @param betraege
	 * @param max
	 * @return
	 */
	public static int eingabe(double betraege[], int max) {
		int anzahl = 1;
		while (anzahl <= max) {
			TextIO.putf("Zahl %d: ", anzahl);
			double temp = TextIO.getDouble();
			if (temp >= 0) {
				betraege[anzahl - 1] = temp;
				anzahl++;
			} else {
				break;
			}
		}
		return anzahl;
	}

	/**
	 * Die Funktion liefert die Summe der ersten anzahl Werte im array betraege
	 * zurück.
	 * 
	 * @param betraege
	 * @param anzahl
	 * @return
	 */
	public static double summe(double betraege[], int anzahl) {
		double summe = 0;
		for (int i = 0; i < anzahl; i++) {
			summe += betraege[i];
		}
		return summe;
	}

}
