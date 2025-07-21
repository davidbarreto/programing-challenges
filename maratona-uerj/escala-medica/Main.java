import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        /**
         * Escreva a sua solução aqui
         * Code your solution here
         * Escriba su solución aquí
         */

        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        
        while (testCases-- > 0) {
            
            int n = scan.nextInt();
            int d1 = scan.nextInt();
            int d2 = scan.nextInt();

            List<Availability> ava = readAvailabilities(scan, n, d1, d2);
            System.out.println("Array len after reading: " + ava.size());
            System.out.println(calculateTotal(ava, d1, d2));

        }
    }

    private static int calculateTotal(List<Availability> ava, int d1, int d2) {

        int lower = Integer.MAX_VALUE;
        int upper = d2;
        int count = 0;
        while (lower > d1) {

            for (Availability a : ava) {
                if (a.f >= upper) {
                    count++;
                    lower = a.c;
                    upper = a.c - 1;
                    break;
                }
            }
        }

        return count;
    }

    private static List<Availability> readAvailabilities(Scanner scan, int n, int d1, int d2) {
        List<Availability> ava = new ArrayList<>();
        while (n-- > 0) {
            int c = scan.nextInt();
            int f = scan.nextInt();
            if (f < d1 || c > d2 || c > f) {
                continue;
            }

            ava.add(new Availability(c, Math.max(c, d1), Math.min(f,d2)));
        }
        ava.sort(compareAvailability());
        return ava;
    }

    private static Comparator<Availability> compareAvailability() {
        return new Comparator<Availability>() {

            @Override
            public int compare(Availability a, Availability b) {
                if (b.c == a.c) {
                    return b.f - a.f;
                } else {
                    return a.c - b.c;
                }
            }
            
        };
    }
}


class Availability {
    public int ori;
    public int c;
    public int f;
    public Availability(int ori, int c, int f) {
        this.ori = ori;
        this.c = c;
        this.f = f;
    }
    public String toString() {
        return c + " / " + f;
    }
}