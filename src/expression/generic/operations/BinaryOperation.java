package expression.generic.operations;

import expression.generic.calculators.Calculator;

import java.util.Objects;

public abstract class BinaryOperation extends Operation {
    private final TripleExpression operand1;
    private final TripleExpression operand2;

    public BinaryOperation(TripleExpression operand1, TripleExpression operand2) {
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

        @Override
    public <T> T evaluate(T x, T y, T z, Calculator<T> calculator) {
        return calculate(operand1.evaluate(x, y, z, calculator), operand2.evaluate(x, y, z, calculator), calculator);
    }

    protected abstract <T> T calculate(T x, T y, Calculator<T> calculator);

    @Override
    public String toString() {
        return "(" + operand1 + " " + getOperationSymbol() + " " + operand2 + ")";
    }

    protected abstract String getOperationSymbol();

    @Override
    public String toMiniString() {
        String result = addBracketsIf(
                operand1.toMiniString(),
                operand1 instanceof Operation
                        && ((Operation) operand1).getPriority() < this.getPriority()
        );

        result += " " + getOperationSymbol() + " ";

        result += addBracketsIf(
                operand2.toMiniString(),
                operand2 instanceof Operation && (
                        ((Operation) operand2).getPriority() < this.getPriority()
                        || ((Operation) operand2).getPriority() == this.getPriority()
                        && (!this.isAssociative() || !((Operation) operand2).isContinuous())
                )
        );

        return result;
    }

    private String addBracketsIf(String string, boolean addBrackets) {
        return addBrackets ? ("(" + string + ")") : string;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BinaryOperation that = (BinaryOperation) obj;
        return operand1.equals(that.operand1) && operand2.equals(that.operand2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, getClass());
    }
}
