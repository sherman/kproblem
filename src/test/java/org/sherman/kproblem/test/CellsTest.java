package org.sherman.kproblem.test;

import java.util.Iterator;

import org.sherman.kproblem.util.Cells;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CellsTest {
    @Test
    public void nextColumnIndexIterator() {
        Iterator<Character> iter = Cells.getNextColumnIndexIterator();
        assertTrue(iter.hasNext());
        
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String actual = "";
        
        while (iter.hasNext()) {
            actual += iter.next();
        }
        
        assertEquals(actual, expected);
        assertFalse(iter.hasNext());
    }
}
