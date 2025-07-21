import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
 
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
            
            long[] vector = new long[n];
            long[] result = new long[n];
            Stack<Pair> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                vector[i] = scan.nextInt();
            }

            stack.push(new Pair(n-1, vector[n-1]));
            for (int i = n-2; i >= 0; i--) {
                long current = vector[i];
                while (!stack.isEmpty() && current <= stack.peek().value) {
                    Pair p = stack.pop();
                    result[p.index] = current;    
                    
                }
                stack.push(new Pair(i, current));
            }

            while(!stack.isEmpty()) {
                Pair p = stack.pop();
                result[p.index] = -1;
            }

            System.out.print(result[0]);
            for (int i = 1; i < n; i++) {
                System.out.print(" " + result[i]);
            }
            System.out.println();
        }
    }
}

class Pair {
    public final int index;
    public final long value;
    public Pair(int index, long value) {
        this.index = index;
        this.value = value;
    }
}