package expression.generic.calculators;

import expression.exceptions.DivisionByZeroException;
import expression.exceptions.OverflowException;

public class CheckedMathUtils {
    public static int abs(int a) {
        try {
            return a < 0 ? negate(a) : a;
        } catch (OverflowException e) {
            throw new OverflowException(String.format("Overflow when calculating abs %d", a));
        }
    }

    public static int negate(int a) {
        if (a == Integer.MIN_VALUE) {
            throw new OverflowException(String.format("Overflow when negate number %d", a));
        }
        return -a;
    }

    public static int add(int a, int b) {
        if (a >= 0 && b >= 0 && Integer.MAX_VALUE - b < a
                || a <= 0 && b <= 0 && Integer.MIN_VALUE - b > a) {
            throw new OverflowException(String.format("Overflow when adding numbers %d and %d", a, b));
        }
        return a + b;
    }

    public static int subtract(int a, int b) {
        if (a >= 0 && b <= 0 && Integer.MAX_VALUE + b < a
                || a <= 0 && b >= 0 && Integer.MIN_VALUE + b > a) {
            throw new OverflowException(String.format("Overflow when subtract numbers %d and %d", a, b));
        }
        return a - b;
    }

    public static int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a > 0 && b > 0 && a > Integer.MAX_VALUE / b
                || a < 0 && b < 0 && a < Integer.MAX_VALUE / b
                || a > 0 && b < 0 && b < Integer.MIN_VALUE / a
                || a < 0 && b > 0 && a < Integer.MIN_VALUE / b) {
            throw new OverflowException(String.format("Overflow when multiplying numbers %d and %d", a, b));
        }
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new DivisionByZeroException("Division by zero");
        }
        if (a == Integer.MIN_VALUE && b == -1) {
            throw new OverflowException(String.format("Overflow when dividing numbers %d and %d", a, b));
        }
        return a / b;
    }

    public static Integer mod(int a, int b) {
        if (b == 0) {
            throw new DivisionByZeroException("Taking mod division by zero");
        }
        return a - (a / b) * b;
    }
}
