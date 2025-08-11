class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if (prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);
        Deque<Integer> sorted = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        //System.out.println(graph);

        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {

            if (!visited.contains(entry.getKey())) {
                if (!dfs(entry.getKey(), graph, new HashSet<>(), visited, sorted)) {
                    //System.out.println("Cycle detected");
                    return false;
                }
            }
        }
        
        //System.out.println("Finalizing with result = " + sorted);
        return sorted.size() == numCourses;
    }

    // Can't have cycles
    // Handle isolated nodes
    private boolean dfs(int root, Map<Integer, List<Integer>> graph, Set<Integer> beingVisited, Set<Integer> visited, Deque<Integer> sorted) {

        beingVisited.add(root);

        for (int neighbor : graph.get(root)) {
            if (beingVisited.contains(neighbor)) {
                return false;
            } else if (!visited.contains(neighbor) && !dfs(neighbor, graph, beingVisited, visited, sorted)) {
                return false;
            }
        }

        sorted.addLast(root);
        beingVisited.remove(root);
        visited.add(root);

        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int course = 0; course < numCourses; course++) {
            graph.put(course, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graph.get(course).add(prerequisite);
        }

        return graph;
    }
}
