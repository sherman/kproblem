package org.sherman.kproblem.core;

import org.sherman.kproblem.parser.*;

public class LazyValue extends EagerValue<Integer> {
    private boolean evaluated;
    
    private final Expression expression;
    private final SheetContext sheetContext;
    
    public LazyValue(
        Expression expression,
        SheetContext sheetCtx
    ) {
        this.expression = expression;
        this.sheetContext = sheetCtx;
    }
    
    @Override
    public Integer getValue() {
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
