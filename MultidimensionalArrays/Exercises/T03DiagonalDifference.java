package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class T03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        matrix = fillMatrix(size, scanner);
        System.out.println();

        int primaryDiagonal = calculatePrimaryDiagonal(matrix);
        int secondaryDiagonal = calculateSecondaryDiagonal(matrix);

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }

    private static int calculateSecondaryDiagonal(int[][] matrix) {
        int result = 0;
        for (int row = 0; row <matrix.length ; row++) {
                    result += matrix[row][matrix.length - 1 - row];
        }
        return result;
    }

    private static int calculatePrimaryDiagonal(int[][] matrix) {
        int result = 0;
        for (int row = 0; row <matrix.length ; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    result += matrix[row][col];
                }
            }
        }
        return result;
    }

    private static int[][] fillMatrix(int size, Scanner scanner) {
        int[][] matrix = new int[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
