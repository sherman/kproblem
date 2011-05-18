package org.sherman.kproblem.util;

import java.util.Iterator;

public class Cells {
    private Cells() {}
    
    public static Iterator<Character> getNextColumnIndexIterator() {
        return new Iterator<Character>() {
            private char current = 'A';
            
            @Override
            public boolean hasNext() {
                return current <= 'Z';
            }

            @Override
            public Character next() {
                return current++;
            }

            @Override
            public void remove() {
                throw new RuntimeException("No implementation!");
            }
        };
    }
}
