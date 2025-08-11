class Solution {
    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        int goal = n * n;

        Set<Integer> visited = new HashSet<>();
        Deque<Element> queue = new ArrayDeque<>();

        queue.addLast(new Element(1, 0));
        visited.add(1);

        while(!queue.isEmpty()) {

            Element curr = queue.pollFirst();
            int square = curr.square();
            int nextCost = curr.cost() + 1;

            for (int i : neighbors(square)) {
                if (i <= goal) {

                    int val = visit(board, i);
                    int nextSquare = val > 0 ? val : i;

                    if (nextSquare == goal) {
                        return nextCost;
                    }

                    if (!visited.contains(nextSquare)) {
                        queue.addLast(new Element(nextSquare, nextCost));
                        visited.add(nextSquare);
                    }
                }
            }
        }

        return -1;
    }

    private List<Integer> neighbors(int curr) {
        //return List.of(curr + 6, curr + 5, curr + 4, curr + 3, curr + 2, curr + 1);
        return List.of(curr + 1, curr + 2, curr + 3, curr + 4, curr + 5, curr + 6);
    }

    private int visit(int[][] board, int square) {
        Coord c = toCoord(square, board.length);
        return board[c.x()][c.y()];
    }

    private Coord toCoord(int i, int n) {

        int pos = i - 1;
        int mod = pos % n;
        int div = pos / n;
        boolean isEven = div % 2 == 0;

        int x = n - div - 1;
        int y = isEven ? mod : n - mod - 1;

        return new Coord(x, y);
    }

    record Coord(int x, int y) {}
    record Element(int square, int cost) {}
}