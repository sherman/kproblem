package org.sherman.kproblem.parser

import _root_.org.sherman.kproblem.core._;

class SheetContext(sheet:Sheet) {
}

object EmptySheetContext extends SheetContext(null) {
    def instance = this
}