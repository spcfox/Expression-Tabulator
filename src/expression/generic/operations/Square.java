package expression.generic.operations;

import expression.generic.calculators.Calculator;

public class Square extends UnaryOperation {
    public Square(TripleExpression operand) {
        super(operand);
    }

    @Override
    protected String getOperationSymbol() {
        return "square";
    }

    @Override
    protected <T> T calculate(T x, Calculator<T> calculator) {
        return calculator.square(x);
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
