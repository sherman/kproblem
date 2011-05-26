package org.sherman.kproblem.parser

import org.sherman.kproblem.core.EagerValue;
import org.sherman.kproblem.core._;
import org.sherman.kproblem.util._;

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
    def eval(sheetCtx:SheetContext): Int = {
        // FIXME: optimize
        val toIndex = new CellIndex(
            a(1).toString.toInt,
            a(0).toString
        )
        
        val sheet = sheetCtx sheet
        val cell = sheet getCellByIndex toIndex
        
        // guarantees by parser grammar
        if (cell.getValue.isInstanceOf[LazyValue]) {
            val currCell:CellIndex = sheetCtx.currentCell
            //println ("from " + currCell)
            //println ("to " + toIndex)
            
            if (toIndex != currCell)
                sheetCtx addEdge new Vertex[CellIndex](toIndex)
            
            sheetCtx isCycleFound match {
                case true => throw new IllegalArgumentException(
                    "Cycle found."
                );
                case false => {
                    sheetCtx currentCell = toIndex
                    cell.getValue.getValue
                }
            }
        } else if (cell.getValue.isInstanceOf[EagerValue[_]]) {
            throw new IllegalArgumentException(
                String.format(
                    "Reference to cell: {%s}, could not be resolved.",
                    toIndex.toString()
                )
            );
        } else {
            throw new IllegalArgumentException(
                String.format(
                    "Unknown value type in reference expression %s",
                    this.toString()
                )
            );
        }
        /*cell.getValue match {
            //case v:LazyValue => 
            case v:LazyValue[_] => v getValue
            case _ => throw new IllegalArgumentException(
                String.format(
                    "Unknown value type in reference expression %s",
                    this.toString()
                )
            );
        }*/
    }
}    
