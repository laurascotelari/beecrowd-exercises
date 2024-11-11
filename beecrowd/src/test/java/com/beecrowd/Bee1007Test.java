package com.beecrowd;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Bee1007Test 
{
    private static final String FORMATTER = "%.3f";

    @ParameterizedTest(name = "Test with {0} hours")
    @MethodSource("provideParameters")
    public void salaryCalcParamTest(int hours, double amount, double expected)
    {
        double actual = Bee1007.calcSalary(hours, amount);
        String actualFormatted = String.format(FORMATTER, actual);
        String expectedFormatted = String.format(FORMATTER, expected);
        assertTrue(actualFormatted.equals(expectedFormatted));
    }

    @ParameterizedTest(name = "Test with {0} hours")
    @ValueSource(ints = {-10})
    public void assertThrowsNegativeHours(int hours){
        assertThrows(IllegalArgumentException.class, () -> {
            Bee1007.calcSalary(hours, 5.50);
        });
    }

    @ParameterizedTest(name = "Test with {0} hours")
    @ValueSource(doubles = {-5.50})
    public void assertThrowsNegativeAmount(double amount){
        assertThrows(IllegalArgumentException.class, () -> {
            Bee1007.calcSalary(10, amount);
        });
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
                Arguments.of(100, 5.50, 550.00),
                Arguments.of(200, 20.50, 4100.00),
                Arguments.of(145, 15.55, 2254.75)
        );
    }

}
