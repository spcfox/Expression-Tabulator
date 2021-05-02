package expression.generic.operations;

import expression.generic.calculators.Calculator;

public class Subtract extends BinaryOperation {
    public Subtract(TripleExpression operand1, TripleExpression operand2) {
        super(operand1, operand2);
    }

    @Override
    protected String getOperationSymbol() {
        return "-";
    }

    @Override
    protected <T> T calculate(T x, T y, Calculator<T> calculator) {
        return calculator.subtract(x, y);
    }

    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public boolean isAssociative() {
        return true;
    }

    @Override
    public boolean isContinuous() {
        return true;
    }
}
