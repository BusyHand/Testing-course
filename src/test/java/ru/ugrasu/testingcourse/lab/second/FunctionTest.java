package ru.ugrasu.testingcourse.lab.second;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static ru.ugrasu.testingcourse.lab.second.Maths.*;

class FunctionTest {

    private Function function = new Function();

    @DisplayName("Тестирование функции")
    @ParameterizedTest
    @CsvSource({
            "-1, 1.38",
            "-2, 0.29",
            "-3, 0.40",
            "1, 0",
            "2, -0.28",
            "3, -1.08"
    })
    public void givenX_whenExecuteFunction_thenReturnExpectedValue(double x, double expected) {
        double result = function.execute(x);

        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    public void givenZero_whenExecuteFunction_thenThrowIllegalArgumentException() {
        double inputValue = 0;

        assertThatThrownBy(() -> function.execute(inputValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Тестирование снизу вверх ln(x) * cos(x)")
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, -0.28",
            "3, -1.08",
            "4, -0.90",
            "5, 0.45",
            "6.28, 1.83"
    })
    public void givenX_whenCalculateLnCos_thenReturnExpectedValue(double x, double expected) {
        double result = ln(x) * cos(x);

        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @DisplayName("Тестирование снизу вверх sin(x) - cos(x)")
    @ParameterizedTest
    @CsvSource({
            "0, -1",
            "1, 0.3",
            "3.14, 1",
            "6.28, -1"
    })
    public void givenX_whenCalculateSinMinusCos_thenReturnExpectedValue(double x, double expected) {
        double result = sin(x) - cos(x);

        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @DisplayName("Тестирование снизу вверх abs(sin(x) - cos(x))")
    @ParameterizedTest
    @CsvSource({
            "0, 1",
            "1, 0.3",
            "3.14, 1",
            "6.28, 1",
            "-3.14 , 1"
    })
    public void givenX_whenCalculateAbsSinMinusCos_thenReturnExpectedValue(double x, double expected) {
        double result = abs(sin(x) - cos(x));

        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }

    @DisplayName("Тестирование снизу вверх ln(abs(x))")
    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 0.6931",
            "3, 1.0986",
            "4, 1.3863",
            "2.718, 1",
            "6.28, 1.83"
    })
    public void givenX_whenCalculateLnAbs_thenReturnExpectedValue(double x, double expected) {
        double result = ln(abs(x));

        assertThat(result).isEqualTo(expected, withPrecision(0.01));
    }
}