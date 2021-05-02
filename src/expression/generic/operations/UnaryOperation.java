package expression.generic.operations;

import expression.generic.calculators.Calculator;

import java.util.Objects;

public abstract class UnaryOperation extends Operation {
    private final TripleExpression operand;

    public UnaryOperation(TripleExpression operand) {
        this.operand = operand;
    }

    @Override
    public <T> T evaluate(T x, T y, T z, Calculator<T> calculator) {
        return calculate(operand.evaluate(x, y, z, calculator), calculator);
    }

    protected abstract <T> T calculate(T x, Calculator<T> calculator);

    @Override
    public String toString() {
        return "(" + getOperationSymbol() + operand + ")";
    }

    protected abstract String getOperationSymbol();

    @Override
    public String toMiniString() {
        if (operand instanceof Operation && ((Operation) operand).getPriority() < getPriority()
                || operand instanceof UnaryOperation) {
            return getOperationSymbol() + "(" + operand.toMiniString() + ")";
        } else {
            return getOperationSymbol() + operand.toMiniString();
        }
    }

    @Override
    public boolean isAssociative() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UnaryOperation that = (UnaryOperation) obj;
        return operand.equals(that.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand, getClass());
    }
}
