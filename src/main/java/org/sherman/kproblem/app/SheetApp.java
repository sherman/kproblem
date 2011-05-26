package org.sherman.kproblem.app;

import org.sherman.kproblem.core.Sheet;
import org.sherman.kproblem.util.Sheets;

public class SheetApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        InputValidator.validate(args);
        
        String[][] elts = InputValidator.getElts();
        
        Sheet sheet = Sheets.buildFrom(elts);
        System.out.print(sheet.getValue());
    }
    
    public static class InputValidator {
        private static String[][] elts;
        
        public static String[][] getElts() {
            return elts;
        }
        
        /**
         * @throws IllegalArgumentException
         */
        public static void validate(String[] args) {
            int rows = Integer.parseInt(args[0]);
            int columns = Integer.parseInt(args[1]);
            
            elts = new String[rows][columns];
            
            int arrayIndex = 2; 
            
            try {
                for (int i = 2; i < rows + 2; i++) {
                    for (int j = 0; j < columns; j++) {
                        //System.out.println((i - 2) + "_" + j + "_" + ":" + args[arrayIndex]);
                        elts[i - 2][j] = args[arrayIndex];
                        arrayIndex++;
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException(
                    String.format(
                        "Not enough elts. Required: %d x %d",
                        rows,
                        columns
                    )
                );
            }
        }
    }
}
