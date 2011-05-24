package org.sherman.kproblem.core;

import org.sherman.kproblem.parser.*;

public class SimpleCell implements Cell {
    private final Expression expression;
    private final Sheet sheet;
    private final SheetContext sheetContext;
    
    public SimpleCell(Sheet sheet, Expression expression) {
        this.sheet = sheet;
        this.expression = expression;
        this.sheetContext = new SheetContext(sheet);
    }

    @Override
    public String getValue() {
        return "" + expression.eval(sheetContext);
    }

    @Override
    public Expression getExpression() {
        return expression;
    }
}
