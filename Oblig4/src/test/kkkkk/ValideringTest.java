package test.kkkkk;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import kkkkk.Validering;

public class ValideringTest {

	@Test
	public void erGyldigTest() {
		Validering val = new Validering("Kjetil", "Johansen", "95335603", "qwerty", "qwerty", "mann");
		assertTrue(val.erFornavnGyldig());
		assertTrue(val.erEtternavnGyldig());
		assertTrue(val.erMobilGyldig());
		assertTrue(val.erPassordGyldig());
		assertTrue(val.erKjonnGyldig());
	}
	
	@Test
	public void erUgyldigTest() {
		Validering val = new Validering("Kjet", "Johan", "953356031", "pass2", "pass", null);
		assertFalse(val.erFornavnGyldig());
		assertFalse(val.erEtternavnGyldig());
		assertFalse(val.erMobilGyldig());
		assertFalse(val.erPassordGyldig());
		assertFalse(val.erKjonnGyldig());
	}
}
