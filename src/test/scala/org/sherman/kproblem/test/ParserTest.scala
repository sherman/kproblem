package org.sherman.kproblem.test

import _root_.org.testng.annotations._
import _root_.org.testng.annotations.DataProvider
import _root_.org.testng.Assert._
import _root_.org.sherman.kproblem.parser._
import _root_.org.sherman.kproblem.core._

class ParserTest {
    @Test(dataProvider="expressions")
    def parseInt(expected:EvaluationStrategy[_], expression:String) {
        assertEquals(expected.getValue, Parser.parse(expression).eval);
    }
    
    @DataProvider(name="expressions")
    def createExpressions = {
        Array(
            Array(new ConstantValue[Int](2), "2"), 
            Array(new ConstantValue[Int](4), "=2+2"),
            Array(new ConstantValue[Int](0), "=2-2"),
            Array(new ConstantValue[Int](16), "=10-2*2"),
            Array(new ConstantValue[Int](12), "=10/2*2+2"),
            Array(new ConstantValue[String]("22+1"), "'22+1")
        )
    }
}