package org.sherman.kproblem.util;

public class Vertex<T> {
    private final T id;
    
    public Vertex(T id) {
        this.id = id;
    }
    
    public T getId() {
        return id;
    }
    
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        @SuppressWarnings("unchecked")
        Vertex<T> v = (Vertex<T>) o;
        
        return v.id.equals(id);
    }
}
