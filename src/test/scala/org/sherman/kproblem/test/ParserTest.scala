package org.sherman.kproblem.test

import _root_.org.testng.annotations._
import _root_.org.testng.annotations.DataProvider
import _root_.org.testng.Assert._
import _root_.org.sherman.kproblem.parser._
import _root_.org.sherman.kproblem.core._

class ParserTest {
    @Test(dataProvider="expressions")
    def parseInt(expected:String, expression:String) {
        assertEquals(
            expected,
            Parser.parse(expression, EmptySheetContext).toString()
        );
    }
    
    @DataProvider(name="expressions")
    def createExpressions = {
        Array(
            Array("2", "2"), 
            Array("4", "=2+2"),
            Array("0", "=2-2"),
            Array("16", "=10-2*2"),
            Array("12", "=10/2*2+2"),
            Array("22+1", "'22+1")
        )
    }
}