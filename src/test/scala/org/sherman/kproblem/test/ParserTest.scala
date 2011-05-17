package org.sherman.kproblem.test

import org.testng.annotations._
import org.testng.annotations.DataProvider
import org.testng.Assert._
import org.sherman.kproblem.parser._

class ParserTest {
    @Test(dataProvider="expressions")
    def parseInt(expected:Int, expression:String) {
        assertEquals(expected, Parser.parse(expression));
    }
    
    @Test
    def parseString() {
        // FIXME
        assertEquals(42, Parser.parse(":22+1"))
    }
    
    @DataProvider(name="expressions")
    def createExpressions = {
        Array(
            Array(2, "2"), 
            Array(4, "2+2"),
            Array(0, "2-2"),
            Array(16, "10-2*2"),
            Array(12, "10/2*2+2")
        )
    }
}