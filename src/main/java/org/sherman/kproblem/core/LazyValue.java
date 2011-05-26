package org.sherman.kproblem.core;

import org.sherman.kproblem.parser.*;

public class LazyValue extends EagerValue<Integer> {
    private boolean evaluated;
    
    private final Expression expression;
    private final SheetContext sheetCtx;
    private final CellIndex index;
    
    public LazyValue(
        Expression expression,
        SheetContext sheetCtx
    ) {
        this.expression = expression;
        this.sheetCtx = sheetCtx;
        // save original parser context
        this.index = sheetCtx.currentCell();
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
        
        // restore original parser context
        sheetCtx.currentCell_$eq(index);
        value = expression.eval(sheetCtx);
    }
}
