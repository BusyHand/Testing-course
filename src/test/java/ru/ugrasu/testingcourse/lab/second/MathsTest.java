package ru.ugrasu.testingcourse.lab.second;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class MathsTest {
    @DisplayName("Тестирование функции sin")
    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "3.14, 0",
            "0.52, 0.5",
            "0.785, 0.707",
            "1.04, 0.866",
            "1.57, 1",
            "4.71, -1",
            "6.28, 0"
    })
    public void givenAngle_whenCalculateSin_thenReturnExpectedValue(double angle, double expected) {
        double result = Maths.sin(angle);

        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @DisplayName("Тестирование функции cos")
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "3.14, -1",
            "0.52, 0.866",
            "0.785, 0.707",
            "1.04, 0.5",
            "1.57, 0",
            "4.71, 0",
            "6.28, 1"
    })
    public void givenAngle_whenCalculateCos_thenReturnExpectedValue(double angle, double expected) {
        double result = Maths.cos(angle);

        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @DisplayName("Тестирование функции ln")
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2.718, 1",
            "7.389, 2",
            "20, 2.9957",
            "0.5, -0.6931"
    })
    public void givenValue_whenCalculateLn_thenReturnExpectedValue(double value, double expected) {
        double result = Maths.ln(value);

        assertThat(result).isEqualTo(expected, withPrecision(0.1));
    }

    @DisplayName("Тестирование функции abs")
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "-1, 1",
            "0, 0",
            "3.5, 3.5",
            "-3.5, 3.5"
    })
    public void givenValue_whenCalculateAbs_thenReturnExpectedValue(double value, double expected) {
        double result = Maths.abs(value);

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("Тестирование функции pow")
    @ParameterizedTest
    @CsvSource({
            "2, 3, 8.0",
            "5, 0, 1.0",
            "1.5, 2, 2.25",
            "-2, 3, -8.0",
            "2, -2, 0.25"
    })
    public void givenBaseAndExponent_whenCalculatePow_thenReturnExpectedValue(double base, int exponent, double expected) {
        double result = Maths.pow(base, exponent);

        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @DisplayName("Тестирование функции factorial")
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 6",
            "4, 24",
            "5, 120",
            "10, 3628800"
    })
    public void givenValue_whenCalculateFactorial_thenReturnExpectedValue(int input, long expected) {
        long result = Maths.factorial(input);
        assertThat(result).isEqualTo(expected);
    }
}