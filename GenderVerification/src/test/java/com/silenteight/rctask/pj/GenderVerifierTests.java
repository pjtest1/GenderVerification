package com.silenteight.rctask.pj;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.silenteight.rctask.pj.algorithms.GenderVerifier;

class GenderVerifierTests {

	@Test
	void unknown_name() {
		
		assertThrows(NullPointerException.class, ()->GenderVerifier.getGender(null, false));
		
		assertEquals(GenderVerifier.getGender("", false), "INCONCLUSIVE");
		assertEquals(GenderVerifier.getGender("unknown", false), "INCONCLUSIVE");

		assertThrows(NullPointerException.class, ()->GenderVerifier.getGender(null, true));
		
		assertEquals(GenderVerifier.getGender("", true), "INCONCLUSIVE");
		assertEquals(GenderVerifier.getGender("unknown", true), "INCONCLUSIVE");
	}

	@Test
	void first_token() {
		assertEquals(GenderVerifier.getGender("Jan Maria Rokita", false), "MALE");
		assertEquals(GenderVerifier.getGender("Anna Zbigniew Gertruda", false), "FEMALE");
	}

	@Test
	void all_tokens() {
		assertEquals(GenderVerifier.getGender("Jan Maria Rokita", true), "INCONCLUSIVE");
		assertEquals(GenderVerifier.getGender("Anna Zbigniew Gertruda", true), "FEMALE");
	}

}
