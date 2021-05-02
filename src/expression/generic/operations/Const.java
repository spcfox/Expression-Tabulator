package expression.generic.operations;

import expression.generic.calculators.Calculator;

import java.util.Objects;

public class Const<N extends Number> implements TripleExpression {
    private final N value;

    public Const(N value) {
        this.value = value;
    }

    @Override
    public <T> T evaluate(T x, T y, T z, Calculator<T> calculator) {
        return calculator.valueOf(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public String toMiniString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return value.equals(((Const<?>) obj).value);
    }

    @Override
    public int hashCode() {
         return Objects.hash(value);
    }
}
