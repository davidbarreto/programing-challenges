import java.io.IOException;
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
            int max = Integer.MIN_VALUE;
            int n = scan.nextInt();
            
            String result = "S";
            while (n-- > 0) {
                
                int h = scan.nextInt();
                if (h < max) {
                    result = "N";
                } else {
                    max = h;
                }
            }
            
            System.out.println(result);
        }
    }
}