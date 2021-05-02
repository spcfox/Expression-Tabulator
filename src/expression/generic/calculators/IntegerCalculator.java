package expression.generic.calculators;

import expression.exceptions.DivisionByZeroException;

public class IntegerCalculator extends AbstractIntegerCalculator {
    public static final IntegerCalculator calculator = new IntegerCalculator();

    private IntegerCalculator() {}

    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        if (b == 0) {
            throw new DivisionByZeroException("Division by zero");
        }
        return a / b;
    }

    @Override
    public Integer negate(Integer a) {
        return -a;
    }

    @Override
    public Integer abs(Integer a) {
        return Math.abs(a);
    }

    @Override
    public Integer square(Integer a) {
        return a * a;
    }

    @Override
    public Integer mod(Integer a, Integer b) {
        if (b == 0) {
            throw new DivisionByZeroException("Taking mod division by zero");
        }
        return a - (a / b) * b;
    }
}
