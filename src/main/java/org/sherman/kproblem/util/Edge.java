package org.sherman.kproblem.util;

public class Edge {
    private final Vertex from;
    private final Vertex to;
    
    public Edge(Vertex from, Vertex to) {
        this.from = from;
        this.to = to;
    }
    
    public Vertex getFrom() {
        return from;
    }
    
    public Vertex getTo() {
        return to;
    }
    
    @Override
    public int hashCode() {
        return from.hashCode() + to.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Edge v = (Edge) o;
        
        return v.from.equals(from) && v.to.equals(to);
    }
}
