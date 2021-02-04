package no.hvl.dat102;

import java.util.Scanner;

import no.hvl.data.adt.FilmarkivADT;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filma;
	private String filnavn;



	public Meny(FilmarkivADT filmene) {
		tekstgr = new Tekstgrensesnitt();
		this.filma = filmene;

		System.out.println("----Meny----");

	
		Scanner tast = new Scanner(System.in);
		System.out.println("O for opprette nytt arkiv");
		System.out.println("E for eksisterende arkiv");

		String type = tast.nextLine();

		switch (type) {
		case "O":
			

			System.out.println("Du har valgt å opprette et nytt arkiv");
			System.out.println("Skriv inn navn på fil: ");
			filnavn = tast.nextLine();
			this.filma = new Filmarkiv();
			Fil.skrivTilFil(this.filma, filnavn);
			System.out.println(filnavn + " er opprettet");

			break;

		case "E":
			System.out.println("Du har valgt eksisterende arkiv");
			String navn = tast.nextLine();
			filnavn = navn;
			this.filma = Fil.lesFraFil(navn);
			break;

		default:
			System.out.println("Feil inntastning");

		}

	}

	public void start() {

		Scanner tast = new Scanner(System.in);
		System.out.println("L for legge til Film");
		System.out.println("S for å slette en film");
		System.out.println("T for å søke tittle med spesiell delstreng");
		System.out.println("P for å søke produsent");
		System.out.println("U for å skrive ut statestikk på sjanger");
	

		String type = tast.nextLine();

		switch (type) {
		case "L":
			this.filma.leggTilFilm(tekstgr.lesFilm());
			Fil.skrivTilFil(this.filma, filnavn);
			break;

		case "S":
			System.out.println("Skriv inn filmnr:");
			String slett = tast.nextLine();
			int Fnr = Integer.parseInt(slett);
			if (filma.slettFilm(Fnr)) {
				System.out.println("Filmen er slettet");
			} else {
				System.out.println("Fant ikke filmen");
			}
			Fil.skrivTilFil(filma, filnavn);
			break;

		case "T":
			System.out.println("Skriv inn tittle");
			String delstreng = tast.nextLine();
			tekstgr.skrivUtFilmDelstrengITittel(filma, delstreng);
			break;

		case "P":
			System.out.println("Skriv inn produsent");
			tekstgr.skrivUtFilmProdusent(filma, tast.nextLine());
			break;

		case "U":
			System.out.println("Statestikk");
			tekstgr.skrivUtStatistikk(filma);
			break;

		default:
			System.out.println("Feil inntastning");

		}

		tast.close();

	}

}


