package org.sherman.kproblem.core;

public enum BinaryOperator {
    PLUS {
        @Override
        public Integer map(Integer op1, Integer op2) {
            return op1 + op2;
        }
    },
    MINUS {
        @Override
        public Integer map(Integer op1, Integer op2) {
            return op1 - op2;
        }
    },
    DIV {
        @Override
        public Integer map(Integer op1, Integer op2) {
            if (op2 == 0)
                throw new IllegalArgumentException("Divisition by zero!)");
            
            return op1 / op2;
        }
    },
    MUL {
        @Override
        public Integer map(Integer op1, Integer op2) {
            return op1 * op2;
        }
    };
    
    public abstract Integer map(Integer op1, Integer op2);
}
