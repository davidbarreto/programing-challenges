package br.com.dbarreto.challenge.misc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.dbarreto.challenge.misc.RiverSizes;

public class TestRiverSize {
	
	@Test
	public void case001() {
		RiverSizes problem = new RiverSizes();
		
		int[][] matrix = {{1, 0, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 1, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 0}};
		assertEquals(List.of(1, 2, 2, 2, 5), problem.solve(matrix));
	}

}
