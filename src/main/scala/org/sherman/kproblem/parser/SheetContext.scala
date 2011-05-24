package org.sherman.kproblem.parser

import _root_.org.sherman.kproblem.core._;

class SheetContext(sheet:Sheet, current:CellIndex) {
}

object EmptySheetContext extends SheetContext(null, null) {
    def instance = this
}