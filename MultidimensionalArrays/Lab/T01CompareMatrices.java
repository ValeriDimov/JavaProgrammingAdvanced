package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class T01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixOneSize = scanner.nextLine().split("\\s+");
        int rowsNum = Integer.parseInt(matrixOneSize[0]);

        int[][] matrixOne = getMatrix(rowsNum, scanner);

        String[] matrixTwoSize = scanner.nextLine().split("\\s+");
        int rowsNum2 = Integer.parseInt(matrixTwoSize[0]);

        int[][] matrixTwo = getMatrix(rowsNum2, scanner);

        boolean isEqual = matrixEquals(matrixOne, matrixTwo);
        String print = isEqual ? "equal" :"not equal";
//        if (isEqual) {
//            System.out.println("equal");
//        } else {
//            System.out.println("not equal");
//        }
        System.out.println(print);
    }

    private static boolean matrixEquals(int[][] matrixOne, int[][] matrixTwo) {
        boolean isEqual = true;
        if (matrixOne.length != matrixTwo.length) {
            isEqual = false;
        }
        for (int rows = 0; rows < matrixOne.length; rows++) {
            for (int cols = 0; cols < matrixOne[rows].length; cols++) {
                if (matrixOne[rows].length != matrixTwo[rows].length) {
                    isEqual = false;
                } else {
                    int currentNumOne = matrixOne[rows][cols];
                    int currentNumTwo = matrixTwo[rows][cols];
                    if (currentNumOne != currentNumTwo) {
                        isEqual = false;
                    }
                }
            }
        }
        return isEqual;
    }

    private static int[][] getMatrix(int rowsNum, Scanner scanner) {
        int[][] matrix = new int[rowsNum][];

        for (int rows = 0; rows < rowsNum; rows++) {
            matrix[rows] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

        }
        return matrix;
    }
}
