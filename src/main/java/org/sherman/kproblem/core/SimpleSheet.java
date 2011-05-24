package org.sherman.kproblem.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.sherman.kproblem.util.Cells;

public class SimpleSheet implements Sheet {
    private final Logger log = Logger.getLogger(SimpleSheet.class);
    
    private BoundsCheck boundsCheckInstance = new BoundsCheck();
    
    private final Map<CellIndex, Cell> cells =
        new HashMap<CellIndex, Cell>();

    private final int rows;
    private final int columns;
    
    private String evaulatedValue = "";
    
    public SimpleSheet(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
    
    @Override
    public Sheet putCell(CellIndex index, Cell cell) {
        log.debug(index);
        
        if (cells.containsKey(index)) {
            throw new IllegalArgumentException("Index already exists!");
        }
        if (boundsCheckInstance.isRowIndexOutOfBounds(index.getRow())) {
            throw new IllegalArgumentException("Row out of bounds!");
        }

        if (boundsCheckInstance.isColumnIndexOutOfBounds(index.getColumn())) {
            throw new IllegalArgumentException("Column out of bounds!");
        }
        
        cells.put(index, cell);
        return this;
    }
    
    class BoundsCheck {
        public boolean isRowIndexOutOfBounds(int row) {
            return row < 1 || row > rows;
        }
        
        public boolean isColumnIndexOutOfBounds(String column) {
            // FIXME
            char columnIndex = column.toUpperCase().toCharArray()[0];
            
            int counter = 1;
            
            Iterator<Character> iter = Cells.getNextColumnIndexIterator();
            
            while (iter.hasNext()) {
                if (counter > columns)
                    return true;
                
                if (columnIndex == iter.next())
                    return false;
                
                ++counter;
            }
            
            return true;
        }
    }

    @Override
    public String getValue() {
        Iterator<CellIndex> iter = cells.keySet().iterator();
        
        while (iter.hasNext()) {
            evaulatedValue +=
                cells.get(iter.next()).getValue().toString() + " ";
        }
        
        return evaulatedValue;
    }
}
