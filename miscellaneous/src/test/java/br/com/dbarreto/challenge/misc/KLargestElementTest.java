package br.com.dbarreto.challenge.misc;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KLargestElementTest {

	@Test
	public void testHeap() {
		KLargestElement algo = new KLargestElement();
		int res = algo.solveUsingHeap(Arrays.asList(4, 2, 9, 7, 5, 6, 7, 1, 3), 4);
		assertEquals(6, res);
	}
	
	@Test
	public void testSort() {
		KLargestElement algo = new KLargestElement();
		int res = algo.solveUsingSort(Arrays.asList(4, 2, 9, 7, 5, 6, 7, 1, 3), 4);
		assertEquals(6, res);
	}
	
}
