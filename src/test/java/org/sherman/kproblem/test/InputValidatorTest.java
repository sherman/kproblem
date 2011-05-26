package org.sherman.kproblem.test;

import org.sherman.kproblem.app.SheetApp;
import org.testng.annotations.Test;

public class InputValidatorTest {
    @Test(expectedExceptions=IllegalArgumentException.class)
    public void createSheetWithInvalidInput() {
        SheetApp.InputValidator.validate(
            new String[] {"2", "2", "3", "=A1", "2"}
        );
    }
}
