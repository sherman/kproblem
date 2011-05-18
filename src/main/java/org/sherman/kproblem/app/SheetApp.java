package org.sherman.kproblem.app;

import java.util.Iterator;

import org.sherman.kproblem.core.Cell;
import org.sherman.kproblem.core.CellIndex;
import org.sherman.kproblem.core.EvaluationStrategy;
import org.sherman.kproblem.core.SimpleCell;
import org.sherman.kproblem.core.SimpleSheet;
import org.sherman.kproblem.util.Cells;
import org.sherman.kproblem.parser.*;;

public class SheetApp {

    /**
     * @param args
     */
    public static void main(String[] args) {
        InputValidator.validate(args);
        
        String[][] elts = InputValidator.getElts();
        
        SimpleSheet sheet = new SimpleSheet(2, 2);
        
        for (int i = 0; i < elts.length; i++) {
            Iterator<Character> columnIndex =
                Cells.getNextColumnIndexIterator();
            
            for (int j = 0; j < elts[i].length; j++) {
                // FIXME: move this check to Validator?
                if (!columnIndex.hasNext())
                    throw new IllegalStateException("Too much columns");
                
                CellIndex index =
                    new CellIndex(i + 1, columnIndex.next().toString());
                
                EvaluationStrategy<?> eval = Parser.parse(elts[i][j].trim());
                Cell cell = new SimpleCell(eval);
                sheet.putCell(index, cell);
            }
        }
        
        System.out.print(sheet.getValue());
    }
    
    private static class InputValidator {
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
