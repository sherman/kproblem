package org.sherman.kproblem.core;

public class EagarValue<T> implements Value<T> {
    protected T value;
    
    public EagarValue(T value) {
        this.value = value;
    }
    
    @Override
    public T getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return "" + getValue();
    }
}
