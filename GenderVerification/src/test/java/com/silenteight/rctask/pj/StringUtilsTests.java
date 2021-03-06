package com.silenteight.rctask.pj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.silenteight.rctask.pj.utils.StringUtils;

class StringUtilsTests {

	@Test
	void Trim() {
		assertEquals(StringUtils.trim(null), null);
		assertEquals(StringUtils.trim(""), "");
		assertEquals(StringUtils.trim("   "), "");
		assertEquals(StringUtils.trim("   a"), "a");
		assertEquals(StringUtils.trim("   a   "), "a");
		assertEquals(StringUtils.trim("a   "), "a");
	}

	@Test
	void Capitalize() {
		assertEquals(StringUtils.capitalize(null), null);
		assertEquals(StringUtils.capitalize(""), "");
		assertEquals(StringUtils.capitalize("a"), "A");
		assertEquals(StringUtils.capitalize("aa"), "Aa");
		assertEquals(StringUtils.capitalize("aA"), "Aa");
		assertEquals(StringUtils.capitalize("AA"), "Aa");
	}

}
