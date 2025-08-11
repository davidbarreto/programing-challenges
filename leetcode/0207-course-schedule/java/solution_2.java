class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if (prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> graph = buildGraph(numCourses, prerequisites);
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        //System.out.println(graph);

        for (int course = 0; course < numCourses; course++) {

            if (!visited.contains(course)) {
                if (!dfs(course, graph, visiting, visited)) {
                    //System.out.println("Cycle detected");
                    return false;
                }
            }
        }
        
        //System.out.println("Finalizing with result = " + sorted);
        return true;
    }

    // Can't have cycles
    // Handle isolated nodes
    private boolean dfs(int root, Map<Integer, List<Integer>> graph, Set<Integer> visiting, Set<Integer> visited) {

        visiting.add(root);

        for (int neighbor : graph.getOrDefault(root, Collections.emptyList())) {
            if (visiting.contains(neighbor)) {
                return false;
            } else if (!visited.contains(neighbor) && !dfs(neighbor, graph, visiting, visited)) {
                return false;
            }
        }

        visiting.remove(root);
        visited.add(root);

        return true;
    }

    private Map<Integer, List<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            graph.computeIfAbsent(course, a -> new ArrayList<>()).add(prerequisite);
        }
        return graph;
    }
}
