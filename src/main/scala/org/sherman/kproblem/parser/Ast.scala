package org.sherman.kproblem.parser;

    // FIXME: actually Expression must return EvaluationStrategy(see java code)
    sealed abstract class Expression {
        def eval():Int
    }

    case class ExpressionConst(value:Int) extends Expression {
        def eval():Int = value
    }

    case class ExpressionAdd(a:List[Expression]) extends Expression {
        def eval():Int = a.foldLeft(0)(_ + _.eval)
    }
    
    case class ExpressionSub(a:List[Expression]) extends Expression {
        def eval():Int = a.foldLeft(0)(_ - _.eval)
    }
    
    case class ExpressionMul(a:List[Expression]) extends Expression {
        def eval():Int = a.foldLeft(0)(_ * _.eval)
    }
    
    case class ExpressionDiv(a:List[Expression]) extends Expression {
         def eval():Int = a.foldLeft(0)(_ / _.eval)
    }
    
    case class ExpressionString(a:String)/* extends Expression*/ {
        def eval():String = a
    }
    
