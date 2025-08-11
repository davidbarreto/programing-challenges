class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if (prerequisites.length == 0) {
            return true;
        }

        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];

        //System.out.println(graph);

        for (int course = 0; course < numCourses; course++) {

            if (!visited[course]) {
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
    private boolean dfs(int root, List<Integer>[] graph, boolean[] visiting, boolean[] visited) {

        visiting[root] = true;

        if (graph[root] != null) {
            for (int neighbor : graph[root]) {
                if (visiting[neighbor]) {
                    return false;
                } else if (!visited[neighbor] && !dfs(neighbor, graph, visiting, visited)) {
                    return false;
                }
            }
        }
        
        visiting[root] = false;
        visited[root] = true;

        return true;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] graph = new ArrayList[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];

            if (graph[course] == null) {
                graph[course] = new ArrayList<>();
            }
            graph[course].add(prerequisite);
        }
        return graph;
    }
}
