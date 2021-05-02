package expression.generic.operations;

public abstract class Operation implements TripleExpression {
    protected abstract int getPriority();
    protected abstract boolean isAssociative();
    protected abstract boolean isContinuous();
}
