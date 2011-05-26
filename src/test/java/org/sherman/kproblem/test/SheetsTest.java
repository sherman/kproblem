package org.sherman.kproblem.test;

import org.sherman.kproblem.core.Sheet;
import org.sherman.kproblem.util.Sheets;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SheetsTest {
    @Test
    public void createFrom() {
        Sheet sheet = Sheets.buildFrom(
            new String[][] {
                {"=2+2", "2"},
                {"'striiiing", "=4*5-1/2"}
            }
        );
        
        assertEquals(
            sheet.getValue(),
            "\r\n4 2 " +
            "\r\nstriiiing 9 "
        );
    }
}
