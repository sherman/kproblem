package org.sherman.kproblem.core;

import org.sherman.kproblem.parser.*;

public interface Cell {
    <T> Value<T> getValue();
}
