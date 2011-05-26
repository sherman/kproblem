package org.sherman.kproblem.test;

import org.sherman.kproblem.util.DiGraph;

import org.sherman.kproblem.util.Edge;
import org.sherman.kproblem.util.Vertex;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DiGraphTest {
    @Test
    public void createDiGraph() {
        DiGraph graph = new DiGraph();
        graph.addEdge(new Edge(new Vertex<Integer>(1), new Vertex<Integer>(2)));

        assertTrue(graph.hasVertex(new Vertex<Integer>(1)));
        assertTrue(graph.hasVertex(new Vertex<Integer>(2)));
        assertFalse(graph.hasVertex(new Vertex<Integer>(3)));
        assertTrue(graph.hasEdge(new Edge(new Vertex<Integer>(1), new Vertex<Integer>(2))));
        assertFalse(graph.hasEdge(new Edge(new Vertex<Integer>(1), new Vertex<Integer>(3))));
    }
}
