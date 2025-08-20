package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterToMoveTest {

	private CharactersToMove problem = new CharactersToMove();
	
	@Test
	public void testCase001() {
		// AAAAARAAARA -> 1+2+4+8+16 -(1+2+4) + 1 = 25
		assertEquals(25, problem.getDistance("AAAAARAAARA"));
	}
	
	@Test
	public void testCase002() {
		assertEquals(0, problem.getDistance(""));
	}
	
	@Test
	public void testCase003() {
		assertEquals(0, problem.getDistance("RRRRRRRRRR"));
	}
	
	@Test
	public void testCase004() {
		assertEquals("AAAARRAAARRAA", problem.getInstructions(25));
	}
	
	@Test
	public void testCase005() {
		assertEquals("AAAAARRA", problem.getInstructions(32));
	}
}
