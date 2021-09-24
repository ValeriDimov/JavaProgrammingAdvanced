package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class T04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int columns = Integer.parseInt(size[1]);

        int[][] matrix = fillMatrix(rows, columns, scanner);
        int sumMaxMatrix = calculateMaxSum(matrix);

        System.out.println("Sum = " + sumMaxMatrix);
        int[][] maxMatrix = fillMaxMatrix(matrix);
        printMaxMatrix(maxMatrix);
    }

    private static void printMaxMatrix(int[][] maxMatrix) {
        for (int r = 0; r < maxMatrix.length; r++) {
            for (int c = 0; c < maxMatrix[r].length; c++) {
                System.out.print(maxMatrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMaxMatrix(int[][] maxMatrix) {
        int maxResult = 0;
        int[][] maxTempMatrix = new int[3][3];
        for (int row = 0; row < maxMatrix.length - 2; row++) {
            for (int col = 0; col < maxMatrix[row].length - 2; col++) {
                int tempResult = (maxMatrix[row][col] +
                        maxMatrix[row][col + 1] +
                        maxMatrix[row][col + 2] +
                        maxMatrix[row + 1][col] +
                        maxMatrix[row + 1][col + 1] +
                        maxMatrix[row + 1][col + 2] +
                        maxMatrix[row + 2][col] +
                        maxMatrix[row + 2][col + 1] +
                        maxMatrix[row + 2][col + 2]);
                if (maxResult < tempResult) {
                    maxResult = tempResult;
                    maxTempMatrix = new int[][]{
                            {maxMatrix[row][col], maxMatrix[row][col + 1], maxMatrix[row][col + 2]},
                            {maxMatrix[row + 1][col], maxMatrix[row + 1][col + 1], maxMatrix[row + 1][col + 2]},
                            {maxMatrix[row + 2][col], maxMatrix[row + 2][col + 1], maxMatrix[row + 2][col + 2]}
                    };
                }
            }
        }
        return maxTempMatrix;
    }

    private static int calculateMaxSum(int[][] matrix) {
        int maxResult = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int tempResult = (matrix[row][col] +
                        matrix[row][col + 1] +
                        matrix[row][col + 2] +
                        matrix[row + 1][col] +
                        matrix[row + 1][col + 1] +
                        matrix[row + 1][col + 2] +
                        matrix[row + 2][col] +
                        matrix[row + 2][col + 1] +
                        matrix[row + 2][col + 2]);
                if (maxResult < tempResult) {
                    maxResult = tempResult;
                }
            }
        }

        return maxResult;
    }

    private static int[][] fillMatrix(int rows, int columns, Scanner scanner) {
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
