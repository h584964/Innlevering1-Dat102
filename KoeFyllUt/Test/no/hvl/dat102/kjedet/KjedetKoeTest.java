package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.adt.KoeADTTest;
import no.hvl.dat102.kjedet.*;

public class KjedetKoeTest extends KoeADTTest {

	protected KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
	}

}
