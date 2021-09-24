package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class T03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        char [][] matrixOne = fillMatrix(rows, columns, scanner);
        char [][] matrixTwo = fillMatrix(rows, columns, scanner);

        char[][] matrixOutput = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                char currentChar1 = matrixOne[row][col];
                char currentChar2 = matrixTwo[row][col];

                if (currentChar1 != currentChar2) {
                    matrixOutput[row][col] = '*';
                } else {
                    matrixOutput[row][col] = currentChar1;
                }
            }
        }

        for (int r = 0; r < matrixOutput.length; r++) {
            for (int c = 0; c < matrixOutput[r].length; c++) {
                System.out.print(matrixOutput[r][c] + " ");
            }
            System.out.println();
        }

    }

    private static char[][] fillMatrix(int rows, int columns, Scanner scanner) {
        char[][] matrix = new char[rows][columns];
        for (int row = 0; row < rows; row++) {
            String[] matrixElements = scanner.nextLine().split("\\s+");
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = matrixElements[col].charAt(0);
            }
        }
        return matrix;
    }
}

