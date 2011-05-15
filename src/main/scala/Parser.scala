package org.sherman.kproblem.parser;

import scala.util.parsing.input.StreamReader
import scala.util.parsing.combinator._;
import scala.util.parsing.combinator.lexical;
import scala.util.matching.Regex;

object Parser extends RegexParsers {
    def numericLit = """^[0-9]+""".r
    def stringLit = """^[:][\p{Print}]+$""".r
    
    def expression = ( arithOp | value | printableString )
    
    def value = numericLit ^^ { s => ExpressionConst(s.toInt) }

    def arithOp = ( sum | sub | mul | div )
    
    def sum = repsep(value, "+") ^^ {
        a:List[Expression] => ExpressionAdd(a)
    }
    
    def sub = repsep(value, "-") ^^ {
        a:List[Expression] => ExpressionSub(a)
    }
    
    def mul = repsep(value, "*") ^^ {
        a:List[Expression] => ExpressionMul(a)
    }
    
    def div = repsep(value, "/") ^^ {
        a:List[Expression] => ExpressionDiv(a)
    }
    
    def printableString = stringLit ^^ {
        case a:String => ExpressionString(a)
    }
    
    def main(args: Array[String]): Unit = {
        println(parseAll(expression, args(0)))
    }
}