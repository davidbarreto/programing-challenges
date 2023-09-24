package br.com.dbarreto.challenge.misc;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HasPath {

	public boolean hasPath(Map<Integer, List<Integer>> graph, int src, int dst) {
		
		if (src == dst) {
			return true;
		}
		
		for (Integer neighbor : graph.get(src)) {
			if (hasPath(graph, neighbor, dst)) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean hasPathCyclic(Map<Integer, List<Integer>> graph, int src, int dst) {
		return hasPathCyclic(graph, src, dst, new HashSet<>());
	}
	
	public boolean hasPathCyclic(Map<Integer, List<Integer>> graph, int src, int dst, Set<Integer> seen) {
		
		if (src == dst) {
			return true;
		}
		if (seen.contains(src)) {
			return false;
		}
		
		seen.add(src);
		
		for (Integer neighbor : graph.get(src)) {
			if (hasPathCyclic(graph, neighbor, dst, seen)) {
				return true;
			}
		}
		
		return false;
	}
}
