package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestApartmentTest {

	private BestApartment problem = new BestApartment();
	
	@Test
	public void testCase001() {
	
		List<List<Boolean>> block = new ArrayList<>();
		block.add(Arrays.asList(false, true, false));
		block.add(Arrays.asList(true, false, false));
		block.add(Arrays.asList(true, true, false));
		block.add(Arrays.asList(false, true, false));
		block.add(Arrays.asList(false, true, true));
		
		List<Integer> requirements = Arrays.asList(0, 1, 2);
		
		assertEquals(3, problem.findApartment(block, requirements));
	}
}
