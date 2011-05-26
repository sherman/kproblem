package org.sherman.kproblem.test;

import org.testng.annotations.Test;
import org.sherman.kproblem.core.Value;
import org.sherman.kproblem.parser.*;

import static org.testng.Assert.*;

public class ParserInteropTest {
    @Test
    public void createParser() {
        Value<?> value = Parser.parse("=2*2-1", EmptySheetContext.instance());
        assertEquals("3", value.toString());
    }
}
