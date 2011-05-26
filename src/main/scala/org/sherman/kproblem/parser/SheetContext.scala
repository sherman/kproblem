package org.sherman.kproblem.parser

import org.sherman.kproblem.util.DirectedCycleFinder;

import _root_.org.sherman.kproblem.util._;

import _root_.org.sherman.kproblem.core._;
import _root_.org.sherman.kproblem.util._;

class SheetContext(s:Sheet, cur:CellIndex) { ctx =>
    val sheet = s
    var currentCell = cur
    
    val refsGraph = new DiGraph()
    
    val cycleFinder = new DirectedCycleFinder(refsGraph)
    
    /**
     * Creates edge between current and to
     */
    def addEdge(to:Vertex[CellIndex]) = {
        ctx.refsGraph addEdge new Edge(new Vertex[CellIndex](currentCell), to)
    }
    
    def isCycleFound:Boolean = ctx.cycleFinder.find.isCycleFound
}

object EmptySheetContext extends SheetContext(null, null) {
    def instance = this
}