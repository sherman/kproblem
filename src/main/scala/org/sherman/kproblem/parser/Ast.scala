package org.sherman.kproblem.parser

sealed abstract class Expression {
    def eval(sheetCtx:SheetContext): Int
}

case class ExpressionConst(value: Int) extends Expression {
    def eval(sheetCtx:SheetContext): Int = value
}

case class ExpressionAdd(a: Expression, b: Expression) extends Expression {
    def eval(sheetCtx:SheetContext): Int = a.eval(sheetCtx) + b.eval(sheetCtx)
}

case class ExpressionSub(a: Expression, b: Expression) extends Expression {
    def eval(sheetCtx:SheetContext): Int = a.eval(sheetCtx) - b.eval(sheetCtx)
}

case class ExpressionMul(a: Expression, b: Expression) extends Expression {
    def eval(sheetCtx:SheetContext): Int = a.eval(sheetCtx) * b.eval(sheetCtx)
}

case class ExpressionDiv(a: Expression, b: Expression) extends Expression {
    def eval(sheetCtx:SheetContext): Int = a.eval(sheetCtx) / b.eval(sheetCtx)
}

case class ExpressionString(a: String) {
    def eval(sheetCtx:SheetContext): String = a
}

case class ExpressionReference(a: String) extends Expression {
    def eval(sheetCtx:SheetContext): Int = 42
}    
