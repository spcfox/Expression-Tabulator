package expression.generic.calculators;

import expression.exceptions.DivisionByZeroException;

public class IntegerModCalculator extends AbstractIntegerCalculator {
    public static final IntegerModCalculator calculator = new IntegerModCalculator();

    private final static int mod = 1009;
    public final int[] reverse;

    private IntegerModCalculator() {
        reverse = new int[mod];
        findReverses();
    }

    @Override
    public Integer add(Integer a, Integer b) {
        return mod(a + b);
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return mod(a - b);
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return mod(a * b);
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        if (b == 0) {
            throw new DivisionByZeroException("Division by zero");
        }
        return mod((a * reverse[mod(b)]));
    }

    @Override
    public Integer negate(Integer a) {
        return mod(-a);
    }

    @Override
    public Integer abs(Integer a) {
        return mod(Math.abs(a));
    }

    @Override
    public Integer square(Integer a) {
        return mod((a * a));
    }

    @Override
    public Integer mod(Integer a, Integer b) {
        if (b == 0) {
            throw new DivisionByZeroException("Taking mod division by zero");
        }
        return mod(a - a / b * b);
    }

    @Override
    public Integer valueOf(Number value) {
        return mod(super.valueOf(value));
    }

    private int mod(int a) {
        if (a >= 0) {
            return a % mod;
        }
        return (a % mod) + mod;
    }

    private void findReverses() {
        for (int i = 1; i < mod; i++) {
            if (reverse[i] != 0) {
                continue;
            }
            for (int j = i; j < mod; j++) {
                if ((i * j) % mod == 1) {
                    reverse[i] = j;
                    reverse[j] = i;
                    break;
                }
            }
        }
    }
}
