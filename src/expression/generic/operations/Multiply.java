package expression.generic.operations;

import expression.generic.calculators.Calculator;

public class Multiply extends BinaryOperation {
    public Multiply(TripleExpression operand1, TripleExpression operand2) {
        super(operand1, operand2);
    }

    @Override
    protected String getOperationSymbol() {
        return "*";
    }

    @Override
    protected <T> T calculate(T x, T y, Calculator<T> calculator) {
        return calculator.multiply(x, y);
    }

    @Override
    public int getPriority() {
        return 20;
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
