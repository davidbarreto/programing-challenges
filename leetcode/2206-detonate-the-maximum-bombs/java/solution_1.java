class Solution {

    public int maximumDetonation(int[][] bombs) {
        
        Map<String, Value> graph = buildGraph(bombs);
        //System.out.println(graph);

        int max = 0;
        for (String bomb : graph.keySet()) {
            Set<String> visited = new HashSet<>();
            int count = search(bomb, graph, visited);
            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    private Map<String, Value> buildGraph(int[][] bombs) {

        Map<String, Value> graph = new HashMap<>();
        int n = bombs.length;
        for (int i = 0; i < n; i++) {

            int x1 = bombs[i][0];
            int y1 = bombs[i][1];
            int r  = bombs[i][2];

            String key1 = x1 + ";" + y1;
            Value v;
            if (graph.containsKey(key1)) {
                v = graph.get(key1);
                v.samePlace++;
            } else {
                v = new Value();
            }

            graph.put(key1, v);
            
            for (int j = 0; j < n; j++) {

                int x2 = bombs[j][0];
                int y2 = bombs[j][1];

                String key2 = x2 + ";" + y2;

                //System.out.println("Comparing " + key1 + " with radius " + r + " and " + key2);
                if (isBombReached(x1, y1, r, x2, y2)) {
                    graph.get(key1).detonated.add(key2);
                    //System.out.println(key1 + " detonates " + key2);
                }
            }
        }

        return graph;
    }

    private boolean isBombReached(int x1, int y1, int r, int x2, int y2) {
        long dist = square((long) Math.abs(x1-x2)) + square((long) Math.abs(y1-y2));
        long squareRadius = square((long) r);

        //System.out.println("Distance: " + dist + ". r^2: " + squareRadius);
        return dist <= squareRadius;
    }

    private long square(long x) {
        return x * x;
    }

    private int search(String bomb, Map<String, Value> graph, Set<String> visited) {

        if (visited.contains(bomb)) {
            return 0;
        }

        visited.add(bomb);

        Value v = graph.get(bomb);
        int count = v.samePlace;  
        for (String reachedBomb : v.detonated) {
            count += search(reachedBomb, graph, visited);
        }

        return count;
    }

    class Value {

        public Set<String> detonated;
        public int samePlace;

        public Value() {
            detonated = new HashSet<>();
            samePlace = 1;
        }

        public String toString() {
            return detonated.toString();
        }
    }
}