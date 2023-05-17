package com.ezen.biz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SearchMaxTest {
	
	@Test
	public void testSearchMax() {
		assertEquals(4, CalcUtil.searchMax(new int[]{1, 3, 4, 2}));
		assertEquals(-1, CalcUtil.searchMax(new int[]{-12, -1, -3, -4, -2}));
	}
}
