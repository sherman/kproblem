package org.sherman.kproblem.util;

public class Vertex {
    private final int id;
    
    public Vertex(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public int hashCode() {
        return new Integer(id);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Vertex v = (Vertex) o;
        
        return v.id == id;
    }
}
