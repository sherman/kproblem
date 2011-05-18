package org.sherman.kproblem.parser;

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
    
    def fold(a: Expression, l: List[~[String,Expression]]) = l.foldLeft(a){
        case (a1, op ~ a2) => binaryOps(op)(a1, a2)
    }
    
    def expression = ( arithOp | value | printableString )
    
    def value = numericLit ^^ { s => ExpressionConst(s.toInt) }

    def arithOp = value ~ rep(("+" | "-" | "*" | "/") ~ value) ^^ {
        case a ~ l => fold(a, l)
    }
    
    def printableString = "'" ~> stringLit ^^ {
        case a:String => ExpressionString(a)
    }
    
    def parse(in:String):EvaluationStrategy[_] = {
        parseAll(expression, in) match {
            case Success(p:Expression, _) => new ConstantValue[Int](p.eval)
            case Success(p:ExpressionString, _) => new ConstantValue[String](p.eval) 
            case e: NoSuccess =>
                throw new IllegalArgumentException("Bad syntax: "+ in)
        }
    }
    
    def main(args: Array[String]):Unit = {
        println(parseAll(expression, args(0)))
    }
}