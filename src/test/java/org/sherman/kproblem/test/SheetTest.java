package org.sherman.kproblem.test;

import org.sherman.kproblem.core.CellIndex;
import org.sherman.kproblem.core.Sheet;
import org.sherman.kproblem.core.SimpleCell;
import org.sherman.kproblem.core.SimpleSheet;
import org.sherman.kproblem.parser.*;
import org.sherman.kproblem.util.Sheets;
import org.sherman.kproblem.util.Values;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SheetTest {
    @Test
    public void createSheet() {
        SimpleSheet sheet = new SimpleSheet(2, 2);
    }

    @Test
    public void checkRowBounds() {
        SimpleSheet sheet = new SimpleSheet(2, 2);
        sheet.putCell(new CellIndex(2, "A"), new SimpleCell(Values.eager(42)));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void checkRowTopBound() {
        SimpleSheet sheet = new SimpleSheet(2, 2);
        sheet.putCell(new CellIndex(3, "A"), new SimpleCell(Values.eager(42)));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void checkBottomTopBound() {
        SimpleSheet sheet = new SimpleSheet(2, 2);
        sheet.putCell(new CellIndex(0, "A"), new SimpleCell(Values.eager(42)));
    }

    @Test
    public void checkColumnBounds() {
        SimpleSheet sheet = new SimpleSheet(2, 2);
        sheet.putCell(new CellIndex(2, "A"), new SimpleCell(Values.eager(42)));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void checkColumnBottomBound() {
        SimpleSheet sheet = new SimpleSheet(2, 2);
        sheet.putCell(new CellIndex(1, "0"), new SimpleCell(Values.eager(42)));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void checkColumnTopBound() {
        SimpleSheet sheet = new SimpleSheet(2, 2);
        sheet.putCell(new CellIndex(1, "C"), new SimpleCell(Values.eager(42)));
    }

    @Test
    public void createSheetWithDiffCells() {
        SimpleSheet sheet = new SimpleSheet(2, 1);
        sheet.putCell(new CellIndex(1, "A"), new SimpleCell(Values.eager(42)));
    }
    
    @Test
    public void createSheetAndParse() {
        Sheet sheet = Sheets.buildFrom(
            new String[][] {
                {"=17-1*B1", "=5*3"},
                {"'yet another string", "=A1+2"}
            }
        );
        
        assertEquals(
            sheet.getValue(),
            "\r\n240 15 " +
            "\r\nyet another string 242 "
        );
    }
    
    @Test
    public void createSheetWithErrorsAndParse() {
        Sheet sheet = Sheets.buildFrom(
            new String[][] {
                {"=17-1*B1", "5*3"},
                {"'yet another string", "=A1+'srting"}
            }
        );
        
        assertEquals(
            sheet.getValue(),
            "\r\n#Eval:{{1,B}} #Parsing " +
        	"\r\nyet another string #Parsing "
        );
    }
    
    @Test
    public void createSheetWithRecursiveReferencesAndParse() {
        Sheet sheet = Sheets.buildFrom(
            new String[][] {
                {"=17-1*B1", "=5*B2"},
                {"=24-1", "=A1+2"},
                {"'test", "=A3"},
            }
        );
        
        assertEquals(
            sheet.getValue(),
            "\r\n#Cycle #Cycle " +
            "\r\n23 #Cycle " +
            "\r\ntest #Eval:{{3,A}} "
        );
    }
    
    @Test
    public void createSheetWithSelfRecursiveReferencesAndParse() {
        Sheet sheet = Sheets.buildFrom(
            new String[][] {
                {"=A1", "=B1"}
            }
        );
        
        assertEquals(
            sheet.getValue(),
            "\r\n#Cycle #Cycle "
        );
    }
}
