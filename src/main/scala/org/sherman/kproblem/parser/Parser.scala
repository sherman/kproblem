package org.sherman.kproblem.parser

import scala.util.parsing.input.StreamReader
import scala.util.parsing.combinator._
import scala.util.parsing.combinator.lexical
import scala.util.matching.Regex
import _root_.org.sherman.kproblem.core._

object Parser extends RegexParsers {
    val binaryOps:Map[String, (Expression, Expression) => Expression] = Map(
        "+" -> ExpressionAdd,
        "-" -> ExpressionSub,
        "*" -> ExpressionMul,
        "/" -> ExpressionDiv
    )
    
    def numericLit = """^[0-9]+""".r
    def stringLit = """^[\p{Print}]+$""".r
    def referenceLit = """^[A-Z][0-9]""".r
    
    def fold(a: Expression, l: List[~[String,Expression]]) = l.foldLeft(a){
        case (a1, op ~ a2) => binaryOps(op)(a1, a2)
    }
    
    def expression = ( arithOp | refOrValue | printableString )
    
    def value = numericLit ^^ { s => ExpressionConst(s.toInt) }

    def arithOp = "=" ~> refOrValue ~ rep(("+" | "-" | "*" | "/") ~ refOrValue) ^^ {
        case a ~ l => fold(a, l)
    }
    
    def printableString = "'" ~> stringLit ^^ {
        case a:String => ExpressionString(a)
    }
    
    def refernce = referenceLit ^^ { s => ExpressionReference(s) } 
    
    def refOrValue = (value | refernce) 
    
    def parse(in:String, sheetCtx:SheetContext):Value[_] = {
        this.parseAll(expression, in) match {
            case Success(exp:Expression, _) =>
                new LazyValue(exp, sheetCtx)

            case Success(exp:ExpressionString, _) =>
                new EagerValue[String](exp eval sheetCtx)

            case e: NoSuccess => new EagerValue[String]("#Parsing")
        }
    }
    
    def main(args: Array[String]):Unit = {
        println(parseAll(expression, args(0)))
    }
}