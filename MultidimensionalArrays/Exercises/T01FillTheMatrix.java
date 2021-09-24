package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class T01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[size][size];

//        if (pattern.equals("A")) {
//            matrix = fillMatrixPatternByA(size);
//        } else {
//            matrix = fillMatrixPatternByB(size);
//        }
        matrix = pattern.equals("A") ? fillMatrixPatternByA(size) : fillMatrixPatternByB(size);
        printMatrix(matrix);
    }

    private static int[][] fillMatrixPatternByB(int size) {
        int[][] matrix = new int[size][size];
        int startingNum = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startingNum++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = startingNum++;
                }
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixPatternByA(int size) {
        int[][] matrix = new int[size][size];
        int startingNum = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = startingNum++;
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix1) {
        for (int row = 0; row < matrix1.length; row++) {
            for (int col = 0; col < matrix1[row].length; col++) {
                System.out.print(matrix1[row][col] + " ");
            }
            System.out.println();
        }

    }

}
