/*

0 1 0
0 0 0
0 0 1

1 1 1 1 1
1 0 0 0 1
1 0 1 0 1
1 0 0 0 1
1 1 1 1 1

0 0 0 0 0
1 1 0 0 1
1 1 0 0 1
1 1 1 0 0
0 0 0 0 0 

*/

class Solution {
    public int shortestBridge(int[][] grid) {
        
        Queue<List<Integer>> bfsQueue = findFirstIsland(grid);
        
        //System.out.println(island);
        
        while (!bfsQueue.isEmpty()) {
            
            List<Integer> elem = bfsQueue.remove();
            for (List<Integer> neighbor : neighbors(elem.get(0), elem.get(1), grid.length)) {
                if (grid[neighbor.get(0)][neighbor.get(1)] == 1) {
                    return elem.get(2);
                } else if (grid[neighbor.get(0)][neighbor.get(1)] == 0) {
                    bfsQueue.add(List.of(neighbor.get(0), neighbor.get(1), elem.get(2)+1));
                    grid[neighbor.get(0)][neighbor.get(1)] = -1;
                }
            }
        }
        
        return 0;
    }
    
    private Queue<List<Integer>> findFirstIsland(int[][] grid) {
        
        int n = grid.length;
        Queue<List<Integer>> island = new ArrayDeque<>(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, grid, island);
                if (island.size() != 0) {
                    return island;
                }
            }
        }
        
        return island;
    }
    
    private void dfs(int x, int y, int[][] grid, Queue<List<Integer>> island) {
        
        if (grid[x][y] == 0 || grid[x][y] == 2) {
            return;
        }
        
        grid[x][y] = 2;
        island.add(List.of(x, y, 0));
        for (List<Integer> neighbor : neighbors(x, y, grid.length)) {
            dfs(neighbor.get(0), neighbor.get(1), grid, island);
        }
    }
    
    private Set<List<Integer>> neighbors(int x, int y, int n) {
        Set<List<Integer>> result = new HashSet<>();
        
        addNeighborIfValid(x+1, y, n, result);
        addNeighborIfValid(x-1, y, n, result);
        addNeighborIfValid(x, y+1, n, result);
        addNeighborIfValid(x, y-1, n, result);
        
        return result;
    }
    
    private void addNeighborIfValid(int x, int y, int n, Set<List<Integer>> neighbors) {
        if (isValid(x, y, n)) {
            neighbors.add(List.of(x, y));
        }
    }
    
    private boolean isValid(int x, int y, int n) {
        return (x >= 0 && x < n &&
               y >= 0 && y < n);
    }
}