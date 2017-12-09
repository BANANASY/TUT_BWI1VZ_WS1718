package TUT_BB_Session1.ShoeShop;

public class Schuhmodell {
	
	public String Modell;
	public String Herstellermarke;
	public float Preis;

	public String toString () {
		return String.format("Modell: %s\nHersteller: %s\nPreis: %.2f", Modell, Herstellermarke, Preis);
	}
}
