package org.sherman.kproblem.core;

public interface Sheet {
    Sheet putCell(CellIndex index, Cell cell);
    public String getValue();
    public Cell getCellByIndex(CellIndex index);
}
