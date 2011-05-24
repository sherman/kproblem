package org.sherman.kproblem.parser

sealed abstract class Expression {
    def eval(): Int
}

case class ExpressionConst(value: Int) extends Expression {
    def eval(): Int = value
}

case class ExpressionAdd(a: Expression, b: Expression) extends Expression {
    def eval(): Int = a.eval + b.eval
}

case class ExpressionSub(a: Expression, b: Expression) extends Expression {
    def eval(): Int = a.eval - b.eval
}

case class ExpressionMul(a: Expression, b: Expression) extends Expression {
    def eval(): Int = a.eval * b.eval
}

case class ExpressionDiv(a: Expression, b: Expression) extends Expression {
    def eval(): Int = a.eval / b.eval
}

case class ExpressionString(a: String) {
    def eval(): String = a
}

case class ExpressionReference(a: String) extends Expression {
    def eval(): Int = 42
}
    
