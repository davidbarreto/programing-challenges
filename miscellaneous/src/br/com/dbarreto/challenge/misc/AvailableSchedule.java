package br.com.dbarreto.challenge.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two schedules as a list of tuples
 * (in this case, it will be a list of two positions: meeting start e meeting end),
 * get the available spots where it's possible to schedule a meeting
 * of 'duration' minutes. Will be also given the daily bounds as a tuple (not_before, not_after)
 * that shows limitations on the start and end of the working day.
 */
public class AvailableSchedule {

	public List<List<String>> getAvailability(List<List<String>> schedule1, List<String> dailyBound1, List<List<String>> schedule2, List<String> dailyBound2, Integer duration) {
		
		return findResult(group(mergeSchedules(addDailyBounds(schedule1, dailyBound1), addDailyBounds(schedule2, dailyBound2))), duration);
	}

	private List<List<String>> findResult(List<List<String>> schedule, Integer time) {
		
		List<List<String>> ans = new ArrayList<>();
		for (int i = 1; i < schedule.size(); i++) {
			if (diffTime(schedule.get(i).get(0), schedule.get(i-1).get(1)) >= time) {
				ans.add(Arrays.asList(schedule.get(i-1).get(1), schedule.get(i).get(0)));
			}
		}
		return ans;
	}

	private int diffTime(String time1, String time2) {
		return toMinutes(time1) - toMinutes(time2);
	}

	private int toMinutes(String time) {
		String[] times = time.split(":");
		return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
	}

	private List<List<String>> group(List<List<String>> merged) {
		
		List<List<String>> ans = new ArrayList<>();
		int i = 1;
		while (i < merged.size()) {
			
			List<String> pivot = merged.get(i-1);
			
			boolean hasToMerge = true;
			while(hasToMerge && i < merged.size()) {
				
				List<String> current = merged.get(i);
				if (current.get(0).compareTo(pivot.get(1)) <= 0) {
					if (current.get(1).compareTo(pivot.get(1)) > 0) {
						pivot = Arrays.asList(pivot.get(0), current.get(1));
					}
					
					i++;
				} else {
					hasToMerge = false;
				}
			}
			ans.add(pivot);
			i++;
		}
		
		return ans;
	}

	private List<List<String>> mergeSchedules(List<List<String>> schedule1, List<List<String>> schedule2) {

		int size1 = schedule1.size();
		int size2 = schedule2.size();
		List<List<String>> merged = new ArrayList<>(size1 + size2);
		
		int i = 0, j = 0;
		while (i < size1 && j < size2) {
			if (schedule1.get(i).get(0).compareTo(schedule2.get(j).get(0)) < 0) {
				merged.add(schedule1.get(i++));
			} else {
				merged.add(schedule2.get(j++));
			}
		}
		
		while (i < size1) {
			merged.add(schedule1.get(i++));
		}
		
		while (j < size2) {
			merged.add(schedule2.get(j++));
		}
		
		return merged;
	}

	private List<List<String>> addDailyBounds(List<List<String>> schedule, List<String> dailyBound) {
		
		List<List<String>> ans = null;
		
		String notBefore = dailyBound.get(0);
		String notAfter = dailyBound.get(1);
		
		ans = new ArrayList<>(schedule.size() + 2);
		ans.add(Arrays.asList("00:00", notBefore));
		ans.addAll(schedule);
		ans.add(Arrays.asList(notAfter, "23:59"));
		
		return ans;
	}
}
