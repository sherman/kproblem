package org.sherman.kproblem.core;

public class SimpleCell<V> implements Cell<V> {
    private EvaluationStrategy<V>  evaluation;
    
    public SimpleCell(EvaluationStrategy<V> evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public V getValue() {
        return evaluation.getValue();
    }
}
