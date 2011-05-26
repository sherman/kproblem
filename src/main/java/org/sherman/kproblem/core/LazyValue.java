package org.sherman.kproblem.core;

import org.sherman.kproblem.parser.*;

public class LazyValue<T> extends EagarValue<T> {
    private boolean evaluated;
    
    private final Expression expression;
    private final Sheet sheet;
    private final CellIndex index;
    private final SheetContext sheetContext;
    
    public LazyValue(
        Sheet sheet,
        CellIndex index,
        Expression expression
    ) {
        this.sheet = sheet;
        this.index = index;
        this.expression = expression;
        this.sheetContext = new SheetContext(sheet, index);
        
    }
    
    public T getValue() {
        if (!evaluated) {
            evaluate();
        }
        
        return value;
    }
    
    
    
    private void evaluate() {
        assert null != expression;
        
        value = expression.eval(sheetContext);
    }
}
