package TUT_VZ_LAST;

import Utils.TextIO;

public class MovieFunctions {

	public static void main(String[] args) {
		Movie[] myMovies = GenerateMovieArray();
		TextIO.putf("----Printing MyMovies\n");
		print(myMovies);
		// Normalfall
		Movie[] topMovies = success(myMovies);
		TextIO.putf("----Printing TopMovies\n");
		print(topMovies);

		// Fehlerfall
		TextIO.putf("----Printing Doofe Variable\n");
		Movie[] doofeVariable = null;
		print(success(doofeVariable));

	}

	public static void somesort(int[] numbers) {
		int i, j;
		for (i = 0; i < numbers.length - 1; i++) {
			int min_idx = i;
			for (j = i + 1; j < numbers.length; j++)
				if (numbers[j] < numbers[min_idx])
					min_idx = j;
			swap(numbers, i, min_idx);
			/* Ausgabe hier */
		}
	}

	public static void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void print(Movie[] movies) {

		if (movies == null) {
			TextIO.putf("Null\n");
			return;
		}
		for (Movie tMovie : movies) {
			if (tMovie != null) {
				TextIO.putf("Id:\t%02d\nTitel:\t%s\nEJahr:\t%4d\n", tMovie.id, tMovie.titel, tMovie.ejahr);
				TextIO.put("\tMitwirkende:\n");
				for (Person currentPerson : tMovie.mitwirkende) {
					if (currentPerson != null) {
						TextIO.putf("\t%s %s, %s\n", currentPerson.vorname, currentPerson.nachname,
								currentPerson.nation);
					}
				}

				// TextIO.putln(tMovie.mitwirkende!=null?"No Mitwirkende":"Mitwirkende
				// vorhanden");
				TextIO.putln();
			}
		}

	}

	public static Movie[] GenerateMovieArray() {
		Person s = new Person();
		s.id = 1;
		s.vorname = "Samuel";
		s.nachname = "L. Jackson";
		s.nation = "USA";

		Person j = new Person();
		j.id = 2;
		j.vorname = "John";
		j.nachname = "Travolta";
		j.nation = "USA";

		Person u = new Person();
		u.id = 3;
		u.vorname = "Uma";
		u.nachname = "Thurman";
		u.nation = "USA";

		Movie m1 = new Movie();
		m1.id = 1;
		m1.titel = "Pulp Fiction";
		m1.ejahr = 1995;
		m1.budget = 40000000.90;
		m1.einnahmen = 10;
		m1.zuschauer = 100000000;
		m1.mitwirkende[0] = s;
		m1.mitwirkende[1] = j;
		m1.mitwirkende[2] = u;

		Movie m2 = new Movie();
		m2.id = 2;
		m2.titel = "Pulp Fiction 2";
		m2.ejahr = 2025;
		m2.budget = 400000000.90;
		m2.einnahmen = 28;
		m2.zuschauer = 1000000000;
		m2.mitwirkende[0] = s;
		m2.mitwirkende[1] = j;
		m2.mitwirkende[2] = u;

		Movie m3 = new Movie();
		m3.id = 3;
		m3.titel = "Pulp Fiction 3";
		m3.ejahr = 3025;
		m3.budget = 40000000000.90;
		m3.einnahmen = 30;
		m3.zuschauer = 1000000000;
		m3.mitwirkende[0] = s;
		m3.mitwirkende[1] = j;
		m3.mitwirkende[2] = u;

		Movie[] myMovies = new Movie[10];
		myMovies[0] = m1;
		myMovies[5] = m2;
		myMovies[9] = m3;

		return myMovies;
	}

	/**
	 * filtert die überdurchschnittlich einträglichen Filme. Das zurückgegeben Array
	 * enthält alle Filme in m, deren Gewinn über dem mittleren Gewinn der Filme in
	 * m liegt (und nur diese). Im Fehlerfall gibt die Funktion null zurück.
	 * 
	 * @param m
	 * @return
	 */
	public static Movie[] success(Movie[] m) {
		if (m == null) {
			return null;
		}

		double avg = 0;
		double sum = 0;
		int cnt = 0;
		// sum+=m[2].einnahmen;
		for (Movie tMovie : m) {
			if (tMovie != null) {
				sum += tMovie.einnahmen;
				cnt++;
			}
		}

		avg = sum / cnt;

		Movie[] topMovies = new Movie[cnt];

		cnt = 0;
		for (Movie tMovie : m) {
			if (tMovie != null) {
				if (tMovie.einnahmen > avg) {
					topMovies[cnt] = tMovie;
					cnt++;
				}
			}
		}

		return topMovies;
	}

}
