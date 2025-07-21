import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        
        while (testCases-- > 0) {
            
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }

            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            System.out.println(solve(matrix, x1, y1, x2, y2));
        }
    }

    private static int solve(int[][] matrix, int x1, int y1, int x2, int y2) {

        Queue<Node> queue = new LinkedList<>();
        if (isValid(x1, y1, matrix) && isValid(x2, y2, matrix)) {
            queue.add(new Node(x1, y1, 0));
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.x == x2 && current.y == y2) {
                return current.dist;
            }

            int dist = current.dist + 1;
            enqueue(current.x + 1, current.y, dist, queue, matrix);
            enqueue(current.x - 1, current.y, dist, queue, matrix);
            enqueue(current.x, current.y + 1, dist, queue, matrix);
            enqueue(current.x, current.y - 1, dist, queue, matrix);
        }

        return -1;
    }

    private static void enqueue(int x, int y, int dist, Queue<Node> queue, int[][] matrix) {
        if (isValid(x, y, matrix)) {
            queue.add(new Node(x, y, dist));
            matrix[x][y] = 1;
        }
    }

    private static boolean isValid(int x, int y, int[][] matrix) {
        int n = matrix.length;
        return x >= 0 && x < n && y >= 0 && y < n && matrix[x][y] == 0;
    }
}

class Node {
    public final int x;
    public final int y;
    public final int dist;
    public Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}