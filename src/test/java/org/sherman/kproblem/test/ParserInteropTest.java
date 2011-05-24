package org.sherman.kproblem.test;

import org.testng.annotations.Test;
import org.sherman.kproblem.core.EvaluationStrategy;
import org.sherman.kproblem.parser.*;

import static org.testng.Assert.*;

public class ParserInteropTest {
    @Test
    public void createParser() {
        Expression exp = Parser.parse("=2*2-1", null);
        assertEquals(3, exp.eval());
    }
}
