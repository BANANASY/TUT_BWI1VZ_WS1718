package TUT_BB_Session1.ShoeShop;

public class Kunde {

	String Name;
	Schuhmodell[] gekaufteSchuhe = new Schuhmodell[100];
	
	public float getSumPrize() {
		float sum = 0;
//		for (int i = 0; i < gekaufteSchuhe.length; i++) {
//			if(gekaufteSchuhe[i]!=null) {
//				sum += gekaufteSchuhe[i].Preis;
//			} else {
//				break;
//			}
//		}
		for (Schuhmodell schuhmodell : gekaufteSchuhe) {
			if(schuhmodell != null) {
				sum += schuhmodell.Preis;
			} else {
				break;
			}
		}
		return sum;
	}
	
}
