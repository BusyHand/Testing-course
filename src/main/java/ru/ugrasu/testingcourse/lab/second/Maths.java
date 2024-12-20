package ru.ugrasu.testingcourse.lab.second;

import lombok.experimental.UtilityClass;

import java.util.function.Function;

@UtilityClass
public class Maths {

    private static final int PRECISION = 10;

    public double cos(double x) {
        return commonCalculate(i -> pow(-1, i) * pow(x, 2 * i) / factorial(2 * i));
    }

    public double sin(double x) {
        return commonCalculate(i -> pow(-1, i) * pow(x, 2 * i + 1) / factorial(2 * i + 1));
    }

    public double ln(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("ln(x) не определен для x <= 0");
        }
        double y = (x - 1) / (x + 1);
        return commonCalculate(i -> pow(y, 2 * i + 1) / (2 * i + 1)) * 2;
    }

    private double commonCalculate(Function<Integer, Double> calculateFunction) {
        double result = 0.0;
        for (int i = 0; i < PRECISION; i++) {
            result += calculateFunction.apply(i);
        }
        return result;
    }

    public double pow(double base, int exponent) {
        double result = 1.0;
        boolean isNegativeExponent = exponent < 0;
        exponent = (int) abs(exponent);
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return isNegativeExponent ? 1.0 / result : result;
    }

    public double abs(double x) {
        return x < 0 ? -x : x;
    }

    public long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
