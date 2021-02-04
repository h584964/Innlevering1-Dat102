package no.hvl.dat102;

import no.hvl.data.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {

	final static int STDK = 100;
	private Film[] filmtabell;
	private int antall;

	public Filmarkiv() {
		this(STDK);

	}

	public Filmarkiv(int n) {
		filmtabell = new Film[n];
		antall = 0;

	}

	@Override
	public Film[] hentFilmTabell() {
	
		return filmtabell;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		
		if (antall == filmtabell.length) {
			utvidKapasistet();
		}
		filmtabell[antall] = nyFilm;
		antall++;

	}

	@Override
	public boolean slettFilm(int filmnr) {
		System.out.println(antall);
		for (int i = 0; i < antall; i++) {

			if (filmtabell[i].getFilmnr() == filmnr) {
				filmtabell[i] = filmtabell[antall - 1];
				filmtabell[antall - 1] = null;
				antall--;
				return true;

			}
		}

		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		int antall = 0;
		Film[] Tab = new Film[filmtabell.length];
		for (int i = 0; i < filmtabell.length; i++) {
			if (filmtabell[i].getTittle().toUpperCase().contains(delstreng.toUpperCase())) {
				Tab[antall] = filmtabell[i];
				antall++;
			}
		}
		trimTab(Tab, antall);
		return Tab;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		int antall = 0;
		Film[] Tab1 = new Film[filmtabell.length];
		for (int i = 0; i < filmtabell.length; i++) {
			if (filmtabell[i].getProdusent().toUpperCase().contains(delstreng.toUpperCase())) {
				Tab1[antall] = filmtabell[i];
				antall++;
			}
		}
		trimTab(Tab1, antall);
		return Tab1;
	}

	@Override
	public int antall(Sjanger sjanger) {
		int a = 0;
		for (int i = 0; i < antall; i++) {
			if (filmtabell[i].getSjanger().equals(sjanger)) {
				a++;
			}
			
		}

		return a;

	}

	@Override
	public int antall() {
		return antall;
	}

	private Film[] trimTab(Film[] tab, int n) {// n er antall elementer
		Film[] filmtab2 = new Film[n];
		int i = 0;
		while (i < n) {
			filmtab2[i] = tab[i];
			i++;

		}
		return filmtab2;

	}

	private void utvidKapasistet() {
		Film[] hjelpetabell = new Film[(int) Math.ceil(1.1 * filmtabell.length)];
		for (int i = 0; i < filmtabell.length; i++) {
			hjelpetabell[i] = filmtabell[i];
		}
		filmtabell = hjelpetabell;
	}

}
