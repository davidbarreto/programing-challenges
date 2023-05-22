package br.com.dbarreto.challenge.misc;

import java.util.List;

public class SimpleSum {
	
	public Integer sum(List<Integer> values) {
		if (values.isEmpty()) {
			return 0;
		}
		return values.get(0) + sum(values.subList(1, values.size()));
	}
	
	public Integer sum(List<Integer> values, int index) {
		if (index == values.size()) {
			return 0;
		}
		return values.get(0) + sum(values, index+1);
	}
}
