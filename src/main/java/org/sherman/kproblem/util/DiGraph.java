package org.sherman.kproblem.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import com.google.common.collect.Multiset;
import com.google.common.collect.HashMultiset;

public class DiGraph {
    private Set<Vertex> vertices = new HashSet<Vertex>();
    private Map<Vertex, Set<Vertex>> edges;
    private int edgesCount;
    
    public DiGraph(int maxEdges) {
        edges = new HashMap<Vertex, Set<Vertex>>();
    }
    
    public DiGraph addEdge(Edge e) {
        Vertex from = e.getFrom();
        Vertex to = e.getFrom();
        
        addVertex(from).addVertex(to);
        
        // add from -> to edge
        if (!edges.containsKey(from)) {
            edges.put(from, new HashSet<Vertex>());
        }
        
        if (!edges.get(from).contains(to)) {
            edges.get(from).add(to);
        }
        
        ++edgesCount;
        
        return this;
    }
    
    public DiGraph addVertex(Vertex v) {
        if (!vertices.contains(v)) {
            vertices.add(v);
        }
        
        return this;
    }
    
    public boolean hasVertex(Vertex v) {
        return vertices.contains(v);
    }
    
    public boolean hasEdge(Edge e) {
        return
            edges.containsKey(e.getFrom())
            && edges.get(e.getFrom()).contains(e.getTo()); 
    }
}
