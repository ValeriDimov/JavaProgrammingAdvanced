package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class T02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][columns];
        matrix = fillCharMatrix(rows, columns);
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] fillCharMatrix(int rows, int columns) {
        String[][] matrix = new String[rows][columns];
        for (int row = 0; row < rows; row++) {
            StringBuilder elements = new StringBuilder();
            for (int col = 0; col < columns; col++) {
                elements.append((char) (97 + row));
                elements.append((char) (97 + row + col));
                elements.append((char) (97 + row));
                matrix[row][col] = elements.toString();
                elements.delete(0,3);
            }
            System.out.println();

        }
        return matrix;
    }
}
