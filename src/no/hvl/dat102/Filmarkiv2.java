package no.hvl.dat102;

import no.hvl.data.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	private int antall;
	private LinearNode<Film> start;
	
	public Filmarkiv2() {
		start = null;
		antall = 0;
	}
	
	@Override
	public Film[] hentFilmTabell() {
		Film [] tab = new Film [antall];
		LinearNode <Film> t = start;
		
		for(int i = 0; i < antall; i++) {
			tab[i] = t.getElement();
			t = t.getNeste();
		}
		return tab;
	}
	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode <Film> t = new LinearNode<Film>(nyFilm);
		t.setNeste(start);
		start = t;
		antall++;
		
	}
	@Override //ikke bruk pop
	public boolean slettFilm(int filmnr) {
		if(erTom()) {
			return false;
			}
		else if(start.getElement().getFilmnr() == filmnr) {
			start = start.getNeste();
			antall--;
			return true;
		}
		LinearNode <Film> t = start.getNeste();
		LinearNode <Film> forrige = start.getNeste();
		
		if(t.getElement().getFilmnr()== filmnr) {
			forrige.setNeste(t.getNeste());
			t = null; // setter den som ble slettet til null
			antall--;
			return true;
		}
		else {
			forrige = t;
			t = t.getNeste();
		}
		
		return false;
		
	}
	@Override
	public Film[] soekTittel(String delstreng) {
		Film [] tab = new Film[antall];
		int a = 0;
		LinearNode <Film> t = start.getNeste();
		for(int i = 0; i < antall; i++) {
			if(t.getElement().getTittle().toUpperCase().contains(delstreng.toUpperCase())) {
				tab[a] = t.getElement();
				a++;
			}
			t = t.getNeste();
		}
		
		return tab;
		
	}
	@Override
	public Film[] soekProdusent(String delstreng) {
		Film[] tab = new Film[antall];
		int a = 0;
		LinearNode <Film> t = start.getNeste();
		for(int i = 0; i < antall; i++) {
			if(t.getElement().getProdusent().toUpperCase().contains(delstreng.toUpperCase())) {
				tab[a] = t.getElement();
				a++;
			}
			t = t.getNeste();
		}
		return tab;
	}
	@Override
	public int antall(Sjanger sjanger) {
		LinearNode <Film> t = start.getNeste();
		int antallSjanger = 0;
		
		for(int i = 0; i < antall; i++) {
			if(t.getElement().getSjanger().equals(sjanger)) {
				antallSjanger++;
			}
			t = t.getNeste();
		}
		
		return antallSjanger;
	}
	@Override
	public int antall() {
		// TODO Auto-generated method stub
		return antall;
	}
	public boolean erTom() {
		return (antall == 0);
	}
}
