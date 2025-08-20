package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RiverSizeTest {
	
	@Test
	public void case001() {
		RiverSizes problem = new RiverSizes();
		
		int[][] matrix = {{1, 0, 0, 1, 0}, {1, 0, 1, 0, 0}, {0, 0, 1, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 0}};
		assertEquals(List.of(1, 2, 2, 2, 5), problem.solve(matrix));
	}

}
