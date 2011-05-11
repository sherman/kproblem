package org.sherman.kproblem.core;

public class StringToIntParser {
    private final String input;
    
    public static StringToIntParser create(String input) {
        return new StringToIntParser(input);
    }
    
    public StringToIntParser(String input) {
        this.input = input;
    }
    
    public EvaluationStrategy<?> getEvaluation() {
        return new ConstantValue<Integer>(new Integer(input));
    }
}
