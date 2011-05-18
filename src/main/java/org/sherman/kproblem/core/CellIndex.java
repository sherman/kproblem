package org.sherman.kproblem.core;

public final class CellIndex {
    private final int row;
    private final String column;
    
    public CellIndex(int row, String column) {
        if (row < 1)
            throw new IllegalArgumentException("Row index begins from 1.");
        
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public String getColumn() {
        return column;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        CellIndex index = (CellIndex) o;

        if (row != 0 ? !(row == index.row) : index.row != 0)
            return false;
        if (column != null ? !column.equals(index.column) : index.column != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = row != 0 ? new Integer(row).hashCode() : 0;
        result = 31 * result + (column != null ? column.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "{" + row + "," + column + "}";
    }
}
