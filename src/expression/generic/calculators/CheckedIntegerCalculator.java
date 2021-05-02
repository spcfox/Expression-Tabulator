package expression.generic.calculators;

public class CheckedIntegerCalculator extends AbstractIntegerCalculator {
    public static final CheckedIntegerCalculator calculator = new CheckedIntegerCalculator();

    private CheckedIntegerCalculator() {}

    @Override
    public Integer add(Integer a, Integer b) {
        return CheckedMathUtils.add(a, b);
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return CheckedMathUtils.subtract(a, b);
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return CheckedMathUtils.multiply(a, b);
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        return CheckedMathUtils.divide(a, b);
    }

    @Override
    public Integer negate(Integer a) {
        return CheckedMathUtils.negate(a);
    }

    @Override
    public Integer abs(Integer a) {
        return CheckedMathUtils.abs(a);
    }

    @Override
    public Integer square(Integer a) {
        return CheckedMathUtils.multiply(a, a);
    }

    @Override
    public Integer mod(Integer a, Integer b) {
        return CheckedMathUtils.mod(a, b);
    }
}
