package org.sherman.kproblem.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DirectedCycleFinder {
    private final DiGraph graph;
    private Set<Vertex<?>> marked = new HashSet<Vertex<?>>();
    private final Map<Vertex<?>, Boolean> stack;
    private Map<Vertex<?>, Vertex<?>> edgeTo = new HashMap<Vertex<?>, Vertex<?>>();
    private Stack<Vertex<?>> cycle = new Stack<Vertex<?>>();
    
    public DirectedCycleFinder(DiGraph graph) {
        this.graph = graph;
        
        stack = new HashMap<Vertex<?>, Boolean>();
        
        for (Vertex<?> v : graph.getVertices()) {
            stack.put(v, false);
        }
    }
    
    // FIXME: don't create it every time
    public DirectedCycleFinder find() {
        cycle = new Stack<Vertex<?>>();
        for (Vertex<?> v : graph.getVertices()) {
            stack.put(v, false);
        }
        
        marked = new HashSet<Vertex<?>>();
        edgeTo = new HashMap<Vertex<?>, Vertex<?>>();
        
        for (Vertex<?> v : graph.getVertices()) {
            if (!marked.contains(v)) {
                dfs(v);
            }
        }
        
        return this;
    }
    
    public boolean isCycleFound() {
        return !cycle.isEmpty();
    }
    
    public Stack<Vertex<?>> getCycle() {
        return cycle;
    }
    
    private void dfs(Vertex<?> v) {
        stack.put(v, true);
        marked.add(v);
        
        // for all adjacent vertices of v
        for (Vertex<?> adjVertex : graph.getAdjacentVerticesOf(v)) {
            if (!cycle.isEmpty())
                return;
            else if (!marked.contains(adjVertex)) {
                edgeTo.put(adjVertex, v);
                dfs(adjVertex);
            } else if (stack.get(adjVertex)) {
                cycle = new Stack<Vertex<?>>();
                Vertex<?> curr = v;
                while (!curr.equals(adjVertex)) {
                    cycle.push(curr);
                    curr = edgeTo.get(curr);
                }
                
                cycle.push(adjVertex);
                cycle.push(v);
            }
        }
        
        stack.put(v, false);
    }
}
