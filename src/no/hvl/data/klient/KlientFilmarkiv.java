package no.hvl.data.klient;

import no.hvl.dat102.Filmarkiv;
import no.hvl.dat102.Meny;
import no.hvl.dat102.Sjanger;
import no.hvl.data.adt.FilmarkivADT;

public class KlientFilmarkiv {
	public static void main(String[] args) {
	//... meny
	
	FilmarkivADT filma = new Filmarkiv();
	
	Meny meny = new Meny(filma);
	
	
	
	meny.start();
	
	
	}
	
	
}
