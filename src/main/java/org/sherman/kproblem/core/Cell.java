package org.sherman.kproblem.core;

import org.sherman.kproblem.parser.*;

public interface Cell {
    /**
     * String representation of the value
     */
    String getValue();
    /**
     * @return A parse tree, consisting of nested Expressions.
     */
    Expression getExpression();
}
