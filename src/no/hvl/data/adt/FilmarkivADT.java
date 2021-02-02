package no.hvl.data.adt;

import no.hvl.dat102.Film;
import no.hvl.dat102.Sjanger;

public interface FilmarkivADT {
	/**
	 * Returnere en tabell av Filmer 
	 * @return
	 */
	Film[] hentFilmTabell();
	
	/**
	 * Legger til en ny Film 
	 * @param nyFilm
	 */
	void leggTilFilm(Film nyFilm);
	
	/**
	 *  Sletter en Film hvis den fins 
	 * @param filmnr
	 * @return
	 */
	boolean slettFilm(int filmnr);
	
	/**
	 *  Søker og henter Film er med en gitt delstreng
	 * @param delstreng
	 * @return
	 */
	Film[] soekTittel(String delstreng);
	
	/**
	 *  Søker og henter produsenter med en gitt delstreng
	 * @param delstreng
	 * @return
	 */
	
	Film[] soekProdusent(String delstreng);
	/**
	 *  Henter antall Film er for en gitt sjanger 
	 * @param sjanger
	 * @return
	 */
	int antall(Sjanger sjanger);
	
	/**
	 *  Returnerer antall Filmer
	 * @return
	 */
	int antall();
	
	/**
	 * interface 
	 */
	
}
