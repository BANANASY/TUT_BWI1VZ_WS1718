package TUT_BB_Session1.ShoeShop;

import Utils.TextIO;

public class SchoeShop {
	private static Schuhmodell[] produktkatalog = new Schuhmodell[100];
	private static Kunde[] kundenkartei = new Kunde[100];
	private static Schuhmodell[] verkaufteSchuhe = new Schuhmodell[100];

	public static void main(String[] args) {
		createDemoData();
		buildMenu();

	}

	private static void createDemoData() {
		// Produkte anlegen
		produktkatalog[0] = new Schuhmodell();
		produktkatalog[0].Herstellermarke = "Adidas";
		produktkatalog[0].Modell = "Flying Shoe";
		produktkatalog[0].Preis = 49.90F;
		produktkatalog[1] = new Schuhmodell();
		produktkatalog[1].Herstellermarke = "Puma";
		produktkatalog[1].Modell = "Crouching Shoe";
		produktkatalog[1].Preis = 79.90F;
		produktkatalog[2] = new Schuhmodell();
		produktkatalog[2].Herstellermarke = "Nike";
		produktkatalog[2].Modell = "Jordan Air";
		produktkatalog[2].Preis = 179.90F;

		// Kunden anlegen
		kundenkartei[0] = new Kunde();
		kundenkartei[0].Name = "Bruce Lee";
		kundenkartei[1] = new Kunde();
		kundenkartei[1].Name = "Arnold Schwarzenegger";
		kundenkartei[2] = new Kunde();
		kundenkartei[2].Name = "Maria Theresa";
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
			case 6:
				printEinnahmen();
				break;
			case 0:
				return;
			}

		}
	}

	private static void printEinnahmen() {
		float sum = 0;
		for (Schuhmodell schuhmodell : verkaufteSchuhe) {
			if (schuhmodell != null) {
				sum += schuhmodell.Preis;
			} else {
				break;
			}
		}
		TextIO.putf("Bisherige Einnahemen: %.2f€\n", sum);
	}

	private static void verkaufeSchuh() {

		TextIO.putln();
		printKundenkatalog();
		int kundenId = 0;
		boolean invalidEntry;
		
		do {
			invalidEntry = false;
			TextIO.putf("Wähler Kunden per Id\n");
			kundenId = TextIO.getInt();
			if (kundenId < 0 || kundenId >= kundenkartei.length) {
				invalidEntry = true;
				continue;
			}
		} while (invalidEntry);
		TextIO.putln();

		printSchuhKatalog();
		int schuhId = 0;

		do {
			invalidEntry = false;
			TextIO.putf("Wähler Schuh per Id\n");
			schuhId = TextIO.getInt();
			if (schuhId < 0 || schuhId >= verkaufteSchuhe.length) {
				invalidEntry = true;
				continue;
			}
		} while (invalidEntry);

		// add schuh to verkaufte schuhe
		verkaufteSchuhe = ensureCapacity(verkaufteSchuhe);
		for (int i = 0; i < verkaufteSchuhe.length; i++) {
			if (verkaufteSchuhe[i] == null) {
				verkaufteSchuhe[i] = produktkatalog[schuhId];
				TextIO.putln("Schuh den verkauften Schuhen hinzugefügt.");
				break;
			}
		}

		// add shoe to kunde
		kundenkartei[kundenId].gekaufteSchuhe = ensureCapacity(kundenkartei[kundenId].gekaufteSchuhe);
		for (int i = 0; i < kundenkartei[kundenId].gekaufteSchuhe.length; i++) {
			if (kundenkartei[kundenId].gekaufteSchuhe[i] == null) {
				kundenkartei[kundenId].gekaufteSchuhe[i] = produktkatalog[schuhId];
				TextIO.putln("Schuh dem Kunden hinzugefügt.");
				break;
			}
		}
	}

	private static Schuhmodell[] ensureCapacity(Schuhmodell[] array) {
		if (array[array.length - 1] != null) {
			return enlargeArray(array);
		}
		return array;
	}

	private static Schuhmodell[] enlargeArray(Schuhmodell[] array) {
		Schuhmodell[] tempArray = new Schuhmodell[array.length + 1];
		for (int i = 0; i < array.length; i++) {
			tempArray[i] = array[i];
		}
		return tempArray;
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
