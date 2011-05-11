package org.sherman.kproblem.core;

public class ArithmeticOperation implements EvaluationStrategy<Integer> {
    private final OpType opType;
    private final int op1;
    private final int op2;
    private int result;
    private boolean evaluated = false;
    
    public ArithmeticOperation(OpType opType, int op1, int op2) {
        this.opType = opType;
        this.op1 = op1;
        this.op2 = op2;
    }
    
    @Override
    public void evaluate() {
        switch (opType) {
            case PLUS:
                result = op1 + op2;
                break;
                
            case MINUS:
                result = op1 - op2;
                break;
                
            case DIV:
                // TODO:move this specific check to enum?
                if (op2 == 0)
                    throw new IllegalArgumentException("Divisition by zero!)");
                
                result = op1 / op2;
                break;
                
            case MUL:
                result = op1 * op2;
                break;

            default:
                throw new IllegalStateException("Strange thing has happen!");
        }
    }

    @Override
    public Integer getValue() {
        if (!evaluated)
            evaluate();
        
        return result;
    }

}
