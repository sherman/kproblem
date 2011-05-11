package org.sherman.kproblem.core;

public class ConstantValue<T> implements EvaluationStrategy<T> {
    private final T value;
    
    public ConstantValue(T value) {
        this.value = value;
    }
    
    @Override
    public void evaluate() {/*_*/}

    @Override
    public T getValue() {
        return value;
    }
}
