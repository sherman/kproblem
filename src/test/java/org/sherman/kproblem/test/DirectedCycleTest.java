package org.sherman.kproblem.test;

import java.util.Stack;

import org.sherman.kproblem.util.DiGraph;
import org.sherman.kproblem.util.DirectedCycleFinder;
import org.sherman.kproblem.util.Edge;
import org.sherman.kproblem.util.Vertex;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DirectedCycleTest {
    @Test
    public void findCycle() {
        DiGraph graph = new DiGraph().
        addEdge(
            new Edge(new Vertex(1), new Vertex(2))
        ).addEdge(
            new Edge(new Vertex(2), new Vertex(3))
        ).addEdge(
            new Edge(new Vertex(3), new Vertex(1))
        ).addEdge(
            new Edge(new Vertex(1), new Vertex(4))
        );
        
        DirectedCycleFinder finder = new DirectedCycleFinder(graph);
        finder.find();
        Stack<Vertex> expected = new Stack<Vertex>();
        expected.push(new Vertex(2));
        expected.push(new Vertex(1));
        expected.push(new Vertex(3));
        assertEquals(finder.getCycle(), expected);
        
        graph = new DiGraph().
        addEdge(
            new Edge(new Vertex(1), new Vertex(2))
        ).addEdge(
            new Edge(new Vertex(2), new Vertex(1))
        );
        
        finder = new DirectedCycleFinder(graph);
        finder.find();
        expected = new Stack<Vertex>();
        expected.push(new Vertex(1));
        expected.push(new Vertex(2));
        assertEquals(finder.getCycle(), expected);
        
        graph = new DiGraph().
        addEdge(
            new Edge(new Vertex(1), new Vertex(2))
        ).addEdge(
            new Edge(new Vertex(2), new Vertex(3))
        );
        
        finder = new DirectedCycleFinder(graph);
        finder.find();
        expected = new Stack<Vertex>();
        assertEquals(finder.getCycle(), expected);
    }
}
