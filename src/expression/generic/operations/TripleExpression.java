package expression.generic.operations;

import expression.generic.calculators.Calculator;

public interface TripleExpression extends ToMiniString {
    <T> T evaluate(T x, T y, T z, Calculator<T> calculator);
}
