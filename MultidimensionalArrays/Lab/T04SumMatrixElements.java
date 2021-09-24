package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class T04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixSize[0]);
        System.out.println(rows);
        int columns = Integer.parseInt(matrixSize[1]);
        System.out.println(columns);

        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int sumNums = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentNum = matrix[r][c];
                sumNums += currentNum;
            }
        }
        System.out.println(sumNums);
    }
}
