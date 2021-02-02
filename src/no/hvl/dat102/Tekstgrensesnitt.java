package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.data.adt.FilmarkivADT;

public class Tekstgrensesnitt {
	private Scanner tast = new Scanner(System.in);
	private FilmarkivADT filma;

	public FilmarkivADT getFilma() {
		return filma;
	}

	public void setFilma(FilmarkivADT filma) {
		this.filma = filma;
	}

	// lese opplysningene om en FILM fra tastatur
	public Film lesFilm() {
		System.out.println("Fnr: ");
		int Fnr = tast.nextInt();
		tast.nextLine();

		System.out.println("Produsent:");
		String produsent = tast.nextLine();

		System.out.println("Tittle: ");
		String tittle = tast.nextLine();

		System.out.println("År: ");
		int aar = tast.nextInt();
		tast.nextLine();

		System.out.println("Sjanger: ");
		String sjStr = tast.nextLine();
		Sjanger sj = Sjanger.finnSjanger(sjStr);

		System.out.println("Selskap: ");
		String selskap = tast.nextLine();

		Film film = new Film(Fnr, produsent, tittle, aar, sj, selskap);
		return film;
	}

	// vise en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visFilm(Film film) {

		film = new Film();

		System.out.println("Filmnr: " + film.getFilmnr());
		System.out.println("Produsent: " + film.getProdusent());
		System.out.println("Tittle" + film.getTittle());
		System.out.println("År: " + film.getAar());
		System.out.println("Sjanger: " + film.getSjanger());
		System.out.println("Filmselskap: " + film.getFilmselskap());

	}

	// Skrive ut alle Filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT filma, String delstreng) {
		Film[] film = filma.soekTittel(delstreng);

		for (int i = 0; i < film.length; i++) {
			System.out.println(film[i].getTittle());

		}

	}

	// Skriver ut alle Filmer av en produsent / en gruppe
	public void skrivUtFilmProdusent(FilmarkivADT filma, String delstreng) {
		Film[] film1 = filma.soekProdusent(delstreng);

		for (int i = 0; i < film1.length; i++) {
			System.out.println(film1[i].getProdusent());
		}

	}

	// Skrive ut en enkel statistikk som inneholder antall Filmertotalt
	// og hvor mange det er i hver sjanger
	public void skrivUtStatistikk(FilmarkivADT filma) {

		Sjanger[] sjanger = Sjanger.values();
		int[] antallSjanger = new int[sjanger.length];

		System.out.println("Antall filmer: " + filma.antall());

		for (int i = 0; i < sjanger.length; i++) {
			antallSjanger[i] = filma.antall(sjanger[i]);
			System.out.println(sjanger[i] + " " + antallSjanger[i]);
			
//			Alternativ1:
			
//			System.out.println("Antall filmer per sjanger: ");
//			for(Sjanger s : Sjanger.values()) {
//				System.out.println(s.toString() + ": " + filma.antall());
//			}
		}

	}

}
