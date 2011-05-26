package org.sherman.kproblem.core;

public class SimpleCell implements Cell {
    private final Value<?> value;
    
    public SimpleCell(
        Value<?> value
    ) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Value<?> getValue() {
        return value;
    }
}
