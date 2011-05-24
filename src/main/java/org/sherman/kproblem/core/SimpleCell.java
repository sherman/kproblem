package org.sherman.kproblem.core;

import org.sherman.kproblem.parser.*;

public class SimpleCell implements Cell {
    private final Expression expression;
    
    public SimpleCell(Expression expression) {
        this.expression = expression;
    }

    @Override
    public String getValue() {
        return "" + expression.eval();
    }

    @Override
    public Expression getExpression() {
        return expression;
    }
}
