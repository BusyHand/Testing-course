package ru.ugrasu.testingcourse.lab.second;

import static ru.ugrasu.testingcourse.lab.second.Maths.*;

public class Function {


    public double execute(double x) {
        if (x > 0) {
            return ln(x) * cos(x);
        }
        double numerator = abs(sin(x) - cos(x));
        double denominator = ln(abs(x)) + 1;
        return numerator / denominator;
    }

}
