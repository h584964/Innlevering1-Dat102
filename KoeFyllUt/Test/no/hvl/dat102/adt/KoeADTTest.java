package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;

public abstract class KoeADTTest {

	// Referer til koe
	private KoeADT<Integer> koe;

	// Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	protected abstract KoeADT<Integer> reset();

	/**
	 * Hent en ny koe for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}

	/**
	 * Tester om en ny koe er tom.
	 */

	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());

	}

	/**
	 * Tester innKoe - om et nytt element blir lagt inn bak i koen. Tester utKoe -
	 * ta ut første elemnt i køen.
	 */
	@Test
	public final void innOgUtKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		koe.innKoe(e4);
	
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
			assertEquals(e4, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("feilet" + e.getMessage());
		}
	}

	/**
	 * Test om første element i køen blir retunert uten å slette.
	 */
	@Test
	public final void foerste() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);

		try {
			assertEquals(e0, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("feilet" + e.getMessage());
		}

	}

	/**
	 * Test for antall elementer i koe
	 */
	@Test
	public void antallKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);

		assertEquals(3, koe.antall());
	}
}
