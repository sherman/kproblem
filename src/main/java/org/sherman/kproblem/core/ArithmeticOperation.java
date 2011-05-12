package org.sherman.kproblem.core;

public class ArithmeticOperation implements EvaluationStrategy<Integer> {
    private final BinaryOperator opType;
    private final int op1;
    private final int op2;
    private int result;
    private boolean evaluated = false;
    
    public ArithmeticOperation(BinaryOperator opType, int op1, int op2) {
        this.opType = opType;
        this.op1 = op1;
        this.op2 = op2;
    }
    
    @Override
    public void evaluate() {
        result = opType.map(op1, op2);
    }

    @Override
    public Integer getValue() {
        if (!evaluated)
            evaluate();
        
        return result;
    }

}
