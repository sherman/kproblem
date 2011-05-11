package org.sherman.kproblem.core;

public class SimpleCell<T extends EvaluationStrategy<V>, V> implements Cell<T, V> {
    private T evaluation;
    
    public SimpleCell() {
    }

    @SuppressWarnings("unchecked")
    public SimpleCell(String input) {
        // FIXME: real parser works here, parser creation based on input
        evaluation =
            (T) StringToIntParser.create(input).
            getEvaluation();
    }

    @Override
    public V getValue() {
        return evaluation.getValue();
    }
}
