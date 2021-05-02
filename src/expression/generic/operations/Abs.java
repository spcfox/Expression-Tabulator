package expression.generic.operations;

import expression.generic.calculators.Calculator;

public class Abs extends UnaryOperation {
    public Abs(TripleExpression operand) {
        super(operand);
    }

    @Override
    protected String getOperationSymbol() {
        return "abs";
    }

    @Override
    protected <T> T calculate(T x, Calculator<T> calculator) {
        return calculator.abs(x);
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public boolean isContinuous() {
        return true;
    }
}
