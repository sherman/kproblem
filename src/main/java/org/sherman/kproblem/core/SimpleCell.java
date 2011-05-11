package org.sherman.kproblem.core;

public class SimpleCell<T extends EvaluationStrategy<V>, V> implements Cell<T, V> {
    private T evaluation;
    
    public SimpleCell() {
    }

    @Override
    public V getValue() {
        return evaluation.getValue();
    }
}
