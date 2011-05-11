package org.sherman.kproblem.core;

public interface Cell<T extends EvaluationStrategy<V>, V> {
    V getValue();
}
