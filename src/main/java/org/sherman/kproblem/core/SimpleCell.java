package org.sherman.kproblem.core;

import org.sherman.kproblem.parser.*;

public class SimpleCell implements Cell {
    private final Expression expression;
    private final Sheet sheet;
    
    public SimpleCell(Sheet sheet, Expression expression) {
        this.sheet = sheet;
        this.expression = expression;
    }

    @Override
    public String getValue() {
        return "" + expression.eval(EmptySheetContext.instance());
    }

    @Override
    public Expression getExpression() {
        return expression;
    }
}
