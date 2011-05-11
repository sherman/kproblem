package org.sherman.kproblem.core;

public interface EvaluationStrategy<T> {
    public void evaluate();
    public T getValue();
}
