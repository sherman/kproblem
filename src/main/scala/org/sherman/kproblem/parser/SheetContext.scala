package org.sherman.kproblem.parser

import _root_.org.sherman.kproblem.core._;
import _root_.org.sherman.kproblem.util._;

class SheetContext(s:Sheet, current:CellIndex) {
    val sheet:Sheet = s
    private val refMap = Map[CellIndex, Vertex]();
}

object EmptySheetContext extends SheetContext(null, null) {
    def instance = this
}