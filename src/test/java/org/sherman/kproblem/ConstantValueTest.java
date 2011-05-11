package org.sherman.kproblem;

import org.sherman.kproblem.core.ConstantValue;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConstantValueTest {
    @Test
    public void createValue() {
        ConstantValue<Integer> constant = new ConstantValue<Integer>(42);
        assertEquals(42, (int) constant.getValue());
    }
}
