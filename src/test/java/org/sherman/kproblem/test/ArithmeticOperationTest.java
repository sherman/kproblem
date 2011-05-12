package org.sherman.kproblem.test;

import org.sherman.kproblem.core.ArithmeticOperation;
import org.sherman.kproblem.core.BinaryOperator;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArithmeticOperationTest {
    @Test
    public void plusValue() {
        ArithmeticOperation constant = new ArithmeticOperation(BinaryOperator.PLUS, 42, 1);
        assertEquals(43, constant.getValue().intValue());
    }
    
    @Test
    public void minusValue() {
        ArithmeticOperation constant = new ArithmeticOperation(BinaryOperator.MINUS, 42, 1);
        assertEquals(41, constant.getValue().intValue());
    }
    
    @Test
    public void divValue() {
        ArithmeticOperation constant = new ArithmeticOperation(BinaryOperator.DIV, 42, 2);
        assertEquals(21, constant.getValue().intValue());
    }
    
    @Test
    public void mulValue() {
        ArithmeticOperation constant = new ArithmeticOperation(BinaryOperator.MUL, 42, 1);
        assertEquals(42, constant.getValue().intValue());
    }
}

