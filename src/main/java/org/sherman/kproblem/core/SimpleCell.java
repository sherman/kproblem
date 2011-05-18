package org.sherman.kproblem.core;

public class SimpleCell implements Cell {
    private EvaluationStrategy<?>  evaluation;
    
    public SimpleCell(EvaluationStrategy<?> evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public String getValue() {
        return evaluation.getValue().toString();
    }
}
