package TUT_BB_Session1.ShoeShop;

import Utils.TextIO;

public class SchoeShop {
	private static Schuhmodell[] produktkatalog = new Schuhmodell[100];
	private static Kunde[] kundenkartei = new Kunde[100];
	private static Schuhmodell[] verkaufteSchuhe = new Schuhmodell[100];

	public static void main(String[] args) {
		buildMenu();

	}

	/**
	 * Baut Menü
	 */
	private static void buildMenu() {
		TextIO.putln("Willkommen im Schuhshop!");
		while (true) {
			TextIO.putln("Operationscodes: \n" + "1 Neues Modell hinzufügen \n" + "2 Neuen Kunden hinzufügen \n"
					+ "3 Produktkatalog anzeigen\n" + "4 Kundenkartei anzeigen \n" + "5 Schuh verkaufen \n"
					+ "6 Bisherige Tageseinnahmen \n" + "7 Besten Kunden anzeigen \n" + "0 Programm beenden");
			int operation = TextIO.getlnInt();
			switch (operation) {
			case 1:
				TextIO.putln("Modell hinzufügen");
				TextIO.putln("Modellname:");
				String modellname = TextIO.getln();
				TextIO.putln("Hersteller:");
				String hersteller = TextIO.getln();
				TextIO.putln("Preis:");
				float preis = TextIO.getlnFloat();
				modellHinzufuegen(produktkatalog, modellname, hersteller, preis);
				break;
			case 2:
				TextIO.putln("Kunde hinzufügen");
				TextIO.putln("Kundenname:");
				String kundenname = TextIO.getln();
				kundeHinzufuegen(kundenname);
				break;
			case 3:
				printSchuhKatalog();
				break;
			case 4:
				printKundenkatalog();
				break;
			case 5:
				verkaufeSchuh();
				break;
			case 0:
				return;
			}

		}
	}

	private static void verkaufeSchuh() {
		TextIO.putf("Wähler Kunden per Id\n");
		printKundenkatalog();
		int kundenId = 0;
		do {
			kundenId = TextIO.getInt();
			if(kundenId<0) {
				kundenId=kundenkartei.length-1;
			}
		} while (kundenkartei[kundenId]==null);
		TextIO.putf("Wähler Schuh per Id\n");
		printSchuhKatalog();
		int schuhId = 0;
		do {
			schuhId = TextIO.getInt();
			if(schuhId<0) {
				schuhId=produktkatalog.length-1;
			}
		} while (produktkatalog[schuhId]==null);
		TextIO.putf("Kundenid: %d, Schuhid: %d\n", kundenId, schuhId);

	}

	private static void printKundenkatalog() {
		for (int i = 0; i < kundenkartei.length; i++) {
			if (kundenkartei[i] != null) {
				TextIO.putf("Id: %d\tKundenname: %s\nGesamtausgaben: %.2f\n", i, kundenkartei[i].Name,
						kundenkartei[i].getSumPrize());
			} else {
				break;
			}
		}
		TextIO.putln();
	}

	private static void kundeHinzufuegen(String kundenname) {
		Kunde newKunde = new Kunde();
		newKunde.Name = kundenname;
		if (kundenkartei[kundenkartei.length - 1] == null) {
			for (int i = 0; i < kundenkartei.length; i++) {
				if (kundenkartei[i] == null) {
					kundenkartei[i] = newKunde;
					break;
				}

			}
		}
	}

	/**
	 * Gibt alle Schuhe bis zum ersten null wert in der Konsole aus
	 * 
	 * @param produktkatalog
	 */
	private static void printSchuhKatalog() {
		int i = 0;
		for (Schuhmodell tempSchuh : produktkatalog) {
			if (tempSchuh != null) {
				TextIO.putln("Id: " + i + "\t" + tempSchuh);
			} else {
				return;
			}
			i++;
		}
		TextIO.putln();
	}

	/**
	 * Fügt modeele hinzu...
	 * 
	 * @param produktkatalog
	 *            - macht so und so
	 * @param modellname
	 *            - sdfasdas
	 * @param hersteller
	 * @param preis
	 */
	private static void modellHinzufuegen(Schuhmodell[] produktkatalog, String modellname, String hersteller,
			float preis) {
		Schuhmodell neuerSchuh = new Schuhmodell();
		neuerSchuh.Modell = modellname;
		neuerSchuh.Herstellermarke = hersteller;
		neuerSchuh.Preis = preis;
		for (int i = 0; i < produktkatalog.length; i++) {
			if (produktkatalog[i] == null) {
				produktkatalog[i] = neuerSchuh;
				break;
			}
		}

	}
}
