package no.hvl.dat102;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.data.adt.FilmarkivADT;

public class Fil {
	private static final String SKILLE = "#";

	public static FilmarkivADT lesFraFil(String filnavn) {

		FilmarkivADT filmarkiv = null;

		try {
			FileReader fil = new FileReader(filnavn);

			BufferedReader leser = new BufferedReader(fil);

			// Leser den første posten
			String linje = leser.readLine();
			int n = Integer.parseInt(linje);

			// Oppretter filmarkiv
			filmarkiv = new Filmarkiv(n);

			for (int i = 0; i < n; i++) {
				linje = leser.readLine();
				String[] felt = linje.split(SKILLE);

				int fnr = Integer.parseInt(felt[0]);
				String produsent = felt[1];
				String tittle = felt[2];
				int aar = Integer.parseInt(felt[3]);
				Sjanger sjanger = Sjanger.finnSjanger(felt[4]);
				String selskap = felt[5];

				Film film = new Film(fnr, produsent, tittle, aar, sjanger, selskap);

				filmarkiv.leggTilFilm(film);
			}
			// Lukker filen
			leser.close();

		} catch (FileNotFoundException e) {
			System.out.println("Fant ikke filen å lese fra" + filnavn);
			System.exit(1);

		} catch (IOException e) {
			System.out.println("Fant ikke til å lese fra" + e);
			System.exit(2);
		}
		return filmarkiv;
	}

	public static void skrivTilFil(FilmarkivADT filmarkiv, String filnavn) {

		try {
			FileWriter fil = new FileWriter(filnavn, false);
			PrintWriter pw = new PrintWriter(fil);
			int antall = filmarkiv.antall();
			pw.println(antall);
			System.out.println(antall);

			Film[] film = filmarkiv.hentFilmTabell();
			for (int i = 0; i < antall; i++) {

				pw.print(film[i].getFilmnr());
				pw.print(SKILLE);
				pw.print(film[i].getProdusent());
				pw.print(SKILLE);
				pw.print(film[i].getTittle());
				pw.print(SKILLE);
				pw.print(film[i].getAar());
				pw.print(SKILLE);
				pw.print(film[i].getSjanger());
				pw.print(SKILLE);
				pw.println(film[i].getFilmselskap());

				// Ferdig med filen, da skal den lukkes.

			}
			pw.close();
			System.out.println("Done");
		} catch (IOException e) {
			System.out.println("Feil ved skiving til fil " + e);
			e.printStackTrace();
		}

	}
}
