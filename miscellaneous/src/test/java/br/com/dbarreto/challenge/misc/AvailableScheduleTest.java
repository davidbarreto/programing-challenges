package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class AvailableScheduleTest {

	private AvailableSchedule problem = new AvailableSchedule();
	
	@Test
	public void testCase001() {
	
		List<List<String>> schedule1 = Arrays.asList(Arrays.asList("09:00", "10:30"), Arrays.asList("12:00", "13:00"), Arrays.asList("16:00", "18:00"));
		List<String> bound1 = Arrays.asList("09:00", "20:00");
		List<List<String>> schedule2 = Arrays.asList(Arrays.asList("10:00", "11:30"), Arrays.asList("12:30", "14:30"), Arrays.asList("14:30", "15:00"), Arrays.asList("16:00", "17:00"));
		List<String> bound2 = Arrays.asList("10:00", "18:30");
		Integer duration = 30;
		
		List<List<String>> ans = Arrays.asList(Arrays.asList("11:30", "12:00"), Arrays.asList("15:00", "16:00"), Arrays.asList("18:00", "18:30"));
		assertEquals(ans, problem.getAvailability(schedule1, bound1, schedule2, bound2, duration));
	}
}
