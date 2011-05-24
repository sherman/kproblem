package org.sherman.kproblem.parser

import _root_.org.sherman.kproblem.core._;

class SheetContext(cellIndex:CellIndex) {
}

object EmptySheetContext extends SheetContext(null) {
    def instance = this
}