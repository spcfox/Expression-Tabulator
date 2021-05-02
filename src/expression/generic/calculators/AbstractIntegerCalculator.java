package expression.generic.calculators;

public abstract class AbstractIntegerCalculator extends Calculator<Integer> {
    @Override
    public Integer valueOf(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public Integer valueOf(Number value) {
        return value.intValue();
    }
}
