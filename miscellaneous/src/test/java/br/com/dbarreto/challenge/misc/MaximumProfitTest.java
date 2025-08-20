package br.com.dbarreto.challenge.misc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProfitTest {

    private MaximumProfit maximumProfit = new MaximumProfit();

    public static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(List.of(3, 6, 4, 4, 7, 7, 2), 4),
                Arguments.of(List.of(8, 2, 6, 4, 7, 1, 4), 5),
                Arguments.of(List.of(7, 5, 4, 3, 2, 1, 1), 0),
                Arguments.of(List.of(7, 5, 4, 3, 4, 1, 1), 1),
                Arguments.of(List.of(2, 1, 0, -1, -1, -1, -1), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    void testMaximumProfit(List<Integer> input, Integer expected) {
        assertEquals(expected, maximumProfit.maxProfit(input));
        assertEquals(expected, maximumProfit.maxProfitLinear(input));
    }


}