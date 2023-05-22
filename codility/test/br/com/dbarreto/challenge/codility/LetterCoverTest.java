package br.com.dbarreto.challenge.codility;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class LetterCoverTest {

	@Test
	public void shouldFinishWithSucess() {
		
		LetterCover lc = new LetterCover();
		
		assertEquals(2, lc.solution("abc", "bcd"));
		assertEquals(2, lc.solution("axxz", "yzwy"));
		assertEquals(2, lc.solution("bacad", "abada"));
		assertEquals(3, lc.solution("amz", "amz"));
	}
}
