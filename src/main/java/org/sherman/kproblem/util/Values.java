package org.sherman.kproblem.util;

import org.sherman.kproblem.core.EagerValue;

public class Values {
    private Values() {}
    
    public static <T> EagerValue<T> eager(T value) {
        return new EagerValue<T>(value);
    }
}
