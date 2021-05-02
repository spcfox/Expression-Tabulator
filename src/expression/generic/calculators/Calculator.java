package expression.generic.calculators;

public abstract class Calculator<T> {
    public abstract T add(T a, T b);

    public abstract T subtract(T a, T b);

    public abstract T multiply(T a, T b);

    public abstract T divide(T a, T b);

    public abstract T negate(T a);

    public abstract T abs(T a);

    public abstract T square(T a);

    public abstract T mod(T a, T b);

    public abstract T valueOf(String str);

    public abstract T valueOf(Number value);
}
