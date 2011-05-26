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
            new Edge(new Vertex<Integer>(1), new Vertex<Integer>(2))
        ).addEdge(
            new Edge(new Vertex<Integer>(2), new Vertex<Integer>(3))
        ).addEdge(
            new Edge(new Vertex<Integer>(3), new Vertex<Integer>(1))
        ).addEdge(
            new Edge(new Vertex<Integer>(1), new Vertex<Integer>(4))
        );
        
        DirectedCycleFinder finder = new DirectedCycleFinder(graph);
        finder.find();
        Stack<Vertex<Integer>> expected = new Stack<Vertex<Integer>>();
        expected.push(new Vertex<Integer>(3));
        expected.push(new Vertex<Integer>(2));
        expected.push(new Vertex<Integer>(1));
        expected.push(new Vertex<Integer>(3));
        assertEquals(finder.getCycle(), expected);
        
        graph = new DiGraph().
        addEdge(
            new Edge(new Vertex<Integer>(1), new Vertex<Integer>(2))
        ).addEdge(
            new Edge(new Vertex<Integer>(2), new Vertex<Integer>(1))
        );
        
        finder = new DirectedCycleFinder(graph);
        finder.find();
        expected = new Stack<Vertex<Integer>>();
        expected.push(new Vertex<Integer>(2));
        expected.push(new Vertex<Integer>(1));
        expected.push(new Vertex<Integer>(2));
        assertEquals(finder.getCycle(), expected);
        
        graph = new DiGraph().
        addEdge(
            new Edge(new Vertex<Integer>(1), new Vertex<Integer>(2))
        ).addEdge(
            new Edge(new Vertex<Integer>(2), new Vertex<Integer>(3))
        );
        
        finder = new DirectedCycleFinder(graph);
        finder.find();
        expected = new Stack<Vertex<Integer>>();
        assertEquals(finder.getCycle(), expected);
        
        graph = new DiGraph().
        addEdge(
            new Edge(new Vertex<Integer>(1), new Vertex<Integer>(2))
        ).addEdge(
            new Edge(new Vertex<Integer>(2), new Vertex<Integer>(3))
        ).addEdge(
            new Edge(new Vertex<Integer>(3), new Vertex<Integer>(4))
        ).addEdge(
            new Edge(new Vertex<Integer>(4), new Vertex<Integer>(5))
        ).addEdge(
            new Edge(new Vertex<Integer>(5), new Vertex<Integer>(2))
        );
        
        finder = new DirectedCycleFinder(graph);
        finder.find();
        expected = new Stack<Vertex<Integer>>();
        expected.push(new Vertex<Integer>(5));
        expected.push(new Vertex<Integer>(4));
        expected.push(new Vertex<Integer>(3));
        expected.push(new Vertex<Integer>(2));
        expected.push(new Vertex<Integer>(5));
        assertEquals(finder.getCycle(), expected);
    }
}
