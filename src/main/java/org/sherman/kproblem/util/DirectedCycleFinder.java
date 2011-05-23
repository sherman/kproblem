package org.sherman.kproblem.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DirectedCycleFinder {
    private final DiGraph graph;
    private final Set<Vertex> marked = new HashSet<Vertex>();
    private final Map<Vertex, Boolean> stack;
    private final Map<Vertex, Vertex> edgeTo = new HashMap<Vertex, Vertex>();
    private Stack<Vertex> cycle = new Stack<Vertex>();
    private boolean cycleFound;
    
    public DirectedCycleFinder(DiGraph graph) {
        this.graph = graph;
        
        stack = new HashMap<Vertex, Boolean>();
        
        for (Vertex v : graph.getVertices()) {
            stack.put(v, false);
        }
    }
    
    public void find() {
        for (Vertex v : graph.getVertices()) {
            if (!marked.contains(v)) {
                dfs(v);
            }
        }
    }
    
    public Stack<Vertex> getCycle() {
        return cycle;
    }
    
    private void dfs(Vertex v) {
        stack.put(v, true);
        marked.add(v);
        
        // for all adjacent vertices of v
        for (Vertex adjVertex : graph.getAdjacentVerticesOf(v)) {
            if (cycleFound)
                return;
            else if (!marked.contains(adjVertex)) {
                edgeTo.put(adjVertex, v);
                dfs(adjVertex);
            } else if (stack.get(adjVertex)) {
                if (!edgeTo.get(v).equals(adjVertex))
                    cycle.push(edgeTo.get(v));
                
                cycle.push(adjVertex);
                cycle.push(v);
            }
        }
        
        stack.put(v, false);
    }
}
