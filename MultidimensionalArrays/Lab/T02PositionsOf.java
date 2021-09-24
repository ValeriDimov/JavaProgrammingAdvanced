package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class T02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixSize = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixSize[0]);
        int columns = Integer.parseInt(matrixSize[1]);

        int [][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int numToFind = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNum = matrix[row][col];
                if (currentNum == numToFind) {
                    System.out.println(row + " " + col);
                    isFound = true;
                }
            }
        }
        String output = !isFound ? "not found" : "";
        System.out.println(output);
    }
}
