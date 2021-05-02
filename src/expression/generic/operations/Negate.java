package expression.generic.operations;

import expression.generic.calculators.Calculator;

public class Negate extends UnaryOperation {
    public Negate(TripleExpression operand) {
        super(operand);
    }

    @Override
    protected String getOperationSymbol() {
        return "-";
    }

    @Override
    protected <T> T calculate(T x, Calculator<T> calculator) {
        return calculator.negate(x);
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
