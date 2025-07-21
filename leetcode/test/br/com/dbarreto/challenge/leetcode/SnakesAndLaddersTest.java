package br.com.dbarreto.challenge.leetcode;

import br.com.dbarreto.challenge.leetcode.utils.Converter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakesAndLaddersTest {

    private SnakesAndLadders solution = new SnakesAndLadders();

    @Test
    void testCase1() {
        int[][] input = convert(
                "[[-1,-1],[-1,3]]"
        );
        int result = solution.snakesAndLadders(input);
        assertEquals(1, result);
    }

    @Test
    void testCase2() {
        int[][] input = convert(
                "[[-1,-1,-1],[-1,9,8],[-1,8,9]]"
        );
        int result = solution.snakesAndLadders(input);
        assertEquals(1, result);
    }

    @Test
    void testCase3() {
        int[][] input = convert(
                "[[-1,4,-1],[6,2,6],[-1,3,-1]]"
        );
        int result = solution.snakesAndLadders(input);
        assertEquals(2, result);
    }

    @Test
    void testCase4() {
        int[][] input = convert(
                "[[-1,-1,2,21,-1],[16,-1,24,-1,4],[2,3,-1,-1,-1],[-1,11,23,18,-1],[-1,-1,-1,23,-1]]"
        );
        int result = solution.snakesAndLadders(input);
        assertEquals(2, result);
    }

    @Test
    void testCase5() {
        int[][] input = convert(
                "[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]"
        );
        int result = solution.snakesAndLadders(input);
        assertEquals(4, result);
    }

    @Test
    void testCase6() {
        int[][] input = convert(
                "[[-1,-1,30,14,15,-1],[23,9,-1,-1,-1,9],[12,5,7,24,-1,30],[10,-1,-1,-1,25,17],[32,-1,28,-1,-1,32],[-1,-1,23,-1,13,19]]"
        );
        int result = solution.snakesAndLadders(input);
        assertEquals(2, result);
    }

    @Test
    void testCase7() {
        int[][] input = convert(
                "[[-1,-1,-1,-1,48,5,-1],[12,29,13,9,-1,2,32],[-1,-1,21,7,-1,12,49],[42,37,21,40,-1,22,12],[42,-1,2,-1,-1,-1,6],[39,-1,35,-1,-1,39,-1],[-1,36,-1,-1,-1,-1,5]]"
        );
        int result = solution.snakesAndLadders(input);
        assertEquals(3, result);
    }

    @Test
    void testCase8() {
        int[][] input = convert(
                "[[-1,1,2,-1],[2,13,15,-1],[-1,10,-1,-1],[-1,6,2,8]]"
        );
        int result = solution.snakesAndLadders(input);
        assertEquals(2, result);
    }

    @Test
    void testCase9() {
        int[][] input = convert(
                "[[-1,-1,-1,30,-1,144,124,135,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1,167,93,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1,-1,77,-1,-1,90,-1,-1],[-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,122,-1],[-1,-1,-1,23,-1,-1,-1,-1,-1,155,-1,-1,-1],[-1,-1,140,29,-1,-1,-1,-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,115,-1,-1,-1,109,-1,-1,5],[-1,57,-1,99,121,-1,-1,132,-1,-1,-1,-1,-1],[-1,48,-1,-1,-1,68,-1,-1,-1,-1,31,-1,-1],[-1,163,147,-1,77,-1,-1,114,-1,-1,80,-1,-1],[-1,-1,-1,-1,-1,57,28,-1,-1,129,-1,-1,-1],[-1,-1,-1,-1,-1,-1,-1,-1,-1,87,-1,-1,-1]]"
        );
        int result = solution.snakesAndLadders(input);
        assertEquals(6, result);
    }

    int[][] convert(String input) {
        return Converter.stringToMatrix(input);
    }
}
