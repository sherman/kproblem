package org.sherman.kproblem.test;

import org.testng.annotations.Test;
import org.sherman.kproblem.core.EvaluationStrategy;
import org.sherman.kproblem.parser.*;

import static org.testng.Assert.*;

public class ParserInteropTest {
    @Test
    public void createParser() {
        EvaluationStrategy<?> eval = Parser.parse("2*2-1");
        assertEquals(3, eval.getValue());
    }
}