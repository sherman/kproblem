package org.sherman.kproblem.parser

import _root_.org.sherman.kproblem.core._;
import _root_.org.sherman.kproblem.util._;

class SheetContext(s:Sheet, cur:CellIndex) {
    val sheet:Sheet = s
    val currentCell:CellIndex = cur
    
    private val refMap = Map[CellIndex, Vertex]();
}

object EmptySheetContext extends SheetContext(null, null) {
    def instance = this
}