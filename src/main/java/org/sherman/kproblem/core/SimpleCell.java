package org.sherman.kproblem.core;

import org.sherman.kproblem.parser.*;

public class SimpleCell implements Cell {
    private final Value<?> value;
    
    public SimpleCell(
        Value<?> value
    ) {
        this.value = value;
    }

    @Override
    public Value<?> getValue() {
        return value;
    }
}
