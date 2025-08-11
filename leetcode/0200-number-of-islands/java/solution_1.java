import java.util.*;

class Solution {
    public int numIslands(char[][] grid) {
        Set<Coord> seen = new HashSet<>();
        int islandCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (dfs(grid, i, j, seen)) {
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    record Coord(int x, int y) {}

    private boolean dfs(char[][] grid, int i, int j, Set<Coord> seen) {
        if (!isInsideBoundaries(grid, i, j) || seen.contains(new Coord(i, j)) || grid[i][j] == '0') {
            return false;
        }

        seen.add(new Coord(i, j));
        for (Coord neighbor : calculateNeighbors(i, j)) {
            if (!seen.contains(neighbor)) {
                dfs(grid, neighbor.x(), neighbor.y(), seen);    
            }
        }

        return true;
    }

    private boolean isInsideBoundaries(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }

    private List<Coord> calculateNeighbors(int i, int j) {
        List<Coord> coords = new ArrayList<>();
        coords.add(new Coord(i + 1, j));
        coords.add(new Coord(i - 1, j));
        coords.add(new Coord(i, j + 1));
        coords.add(new Coord(i, j - 1));

        return coords;
    }
}
