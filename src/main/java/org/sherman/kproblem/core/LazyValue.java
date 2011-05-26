package org.sherman.kproblem.core;

import org.sherman.kproblem.parser.*;

public class LazyValue<T> extends EagerValue<T> {
    private boolean evaluated;
    
    private final Expression expression;
    private final SheetContext sheetContext;
    
    public LazyValue(
        SheetContext sheetCtx,
        Expression expression
    ) {
        this.expression = expression;
        this.sheetContext = sheetCtx;
        
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
