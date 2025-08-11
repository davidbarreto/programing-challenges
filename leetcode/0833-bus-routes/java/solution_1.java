/*

[[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12


*/

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if (source == target) {
            return 0;
        }
        
        Map<Integer, Set<Integer>> stopToRoutes = new HashMap<>();
        Map<Integer, Set<Integer>> routeToStops = new HashMap<>();
        
        for (int route = 0; route < routes.length; route++) {
            Set<Integer> stops = new HashSet<>();
            for (int stop = 0; stop < routes[route].length; stop++) {
                stops.add(routes[route][stop]);
                stopToRoutes.computeIfAbsent(routes[route][stop], r -> new HashSet<Integer>()).add(route);
            }
            routeToStops.put(route, stops);
        }
        
        Queue<Item> bfsQueue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        
        for (Integer route : stopToRoutes.getOrDefault(source, Collections.emptySet())) {
            bfsQueue.add(new Item(route, 0));
        }
        
        int busCount = 1;
        while (!bfsQueue.isEmpty()) {
            
            //Check if target is in current route
            Item item = bfsQueue.poll();
            //System.out.printf("Dequeued %s\n", item.toString());
            
            //System.out.printf("Visited routes: %s\n", visited.toString());
            if (visited.contains(item.route())) {
                continue;
            }
            
            //System.out.printf("Adding %d to visited nodes\n", item.route());
            visited.add(item.route());

            //System.out.printf("Current stops in route %d: %s\n", item.route(), routeToStops.get(item.route()).toString());
            if (routeToStops.get(item.route()).contains(target)) {
                return item.distance()+1;
            }

            //Enqueue neighbors of current route
            Set<Integer> neighborRoutes = new HashSet<>();
            for (Integer stop : routeToStops.get(item.route())) {
                neighborRoutes.addAll(stopToRoutes.get(stop));
            }
            
            //System.out.printf("Neighbors: %s\n", neighborRoutes.toString());
            for (Integer neighborRoute : neighborRoutes) {
                if (!visited.contains(neighborRoute)) {
                    bfsQueue.add(new Item(neighborRoute, item.distance()+1));
                }
            }
        }
        
        return -1;
    }
    
    record Item(Integer route, Integer distance){}
}