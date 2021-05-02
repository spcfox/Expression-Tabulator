package expression.generic.calculators;

public class DoubleCalculator extends Calculator<Double> {
    public static final DoubleCalculator calculator = new DoubleCalculator();

    private DoubleCalculator() {}

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double subtract(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double divide(Double a, Double b) {
        return a / b;
    }

    @Override
    public Double negate(Double a) {
        return -a;
    }

    @Override
    public Double abs(Double a) {
        return Math.abs(a);
    }

    @Override
    public Double square(Double a) {
        return a * a;
    }

    @Override
    public Double mod(Double a, Double b) {
        return a % b;
    }

    @Override
    public Double valueOf(String str) {
        return Double.parseDouble(str);
    }

    @Override
    public Double valueOf(Number value) {
        return value.doubleValue();
    }
}
