package expression.generic.calculators;

import expression.exceptions.DivisionByZeroException;

public class ByteCalculator extends Calculator<Byte> {
    public static final ByteCalculator calculator = new ByteCalculator();

    private ByteCalculator() {}

    @Override
    public Byte add(Byte a, Byte b) {
        return (byte) (a + b);
    }

    @Override
    public Byte subtract(Byte a, Byte b) {
        return (byte) (a - b);
    }

    @Override
    public Byte multiply(Byte a, Byte b) {
        return (byte) (a * b);
    }

    @Override
    public Byte divide(Byte a, Byte b) {
        if (b == 0) {
            throw new DivisionByZeroException("Division by zero");
        }
        return (byte) (a / b);
    }

    @Override
    public Byte negate(Byte a) {
        return (byte) -a;
    }

    @Override
    public Byte abs(Byte a) {
        return (byte) Math.abs(a);
    }

    @Override
    public Byte square(Byte a) {
        return (byte) (a * a);
    }

    @Override
    public Byte mod(Byte a, Byte b) {
        if (b == 0) {
            throw new DivisionByZeroException("Taking mod division by zero");
        }
        return (byte) (a - a / b * b);
    }

    @Override
    public Byte valueOf(String str) {
        return Byte.parseByte(str);
    }

    @Override
    public Byte valueOf(Number value) {
        return value.byteValue();
    }
}
