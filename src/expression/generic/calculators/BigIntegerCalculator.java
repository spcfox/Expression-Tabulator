package expression.generic.calculators;

import expression.exceptions.DivisionByZeroException;

import java.math.BigInteger;

public class BigIntegerCalculator extends Calculator<BigInteger> {
    public static final BigIntegerCalculator calculator = new BigIntegerCalculator();

    private BigIntegerCalculator() {}

    @Override
    public BigInteger add(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    @Override
    public BigInteger subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    @Override
    public BigInteger multiply(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    @Override
    public BigInteger divide(BigInteger a, BigInteger b) {
        if (b.equals(BigInteger.ZERO)) {
            throw new DivisionByZeroException("Division by zero");
        }
        return a.divide(b);
    }

    @Override
    public BigInteger negate(BigInteger a) {
        return a.negate();
    }

    @Override
    public BigInteger abs(BigInteger a) {
        return a.abs();
    }

    @Override
    public BigInteger square(BigInteger a) {
        return a.multiply(a);
    }

    @Override
    public BigInteger mod(BigInteger a, BigInteger b) {
        if (b.compareTo(BigInteger.ZERO) <= 0) {
            throw new DivisionByZeroException("Taking mod division by non-positive for BigInteger");
        }
        return a.mod(b);
    }

    @Override
    public BigInteger valueOf(String str) {
        return new BigInteger(str);
    }

    @Override
    public BigInteger valueOf(Number value) {
        if (value instanceof BigInteger) {
            return (BigInteger) value;
        }
        return BigInteger.valueOf(value.longValue());
    }
}
