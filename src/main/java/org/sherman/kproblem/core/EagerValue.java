package org.sherman.kproblem.core;

/**
 * Class is used for string values.
*/
public class EagerValue<T> implements Value<T> {
    protected T value;
    
    public EagerValue() {}
    
    public EagerValue(T value) {
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
