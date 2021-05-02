package expression.generic.operations;

import expression.generic.calculators.Calculator;

public class Add extends BinaryOperation {
    public Add(TripleExpression operand1, TripleExpression operand2) {
        super(operand1, operand2);
    }

    @Override
    protected String getOperationSymbol() {
        return "+";
    }

    @Override
    protected <T> T calculate(T x, T y, Calculator<T> calculator) {
        return calculator.add(x, y);
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
