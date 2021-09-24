package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class T05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(size[0]);
        int columns = Integer.parseInt(size[1]);

        String[][] matrix = fillStringMatrix(rows, scanner);

        String commands = scanner.nextLine();
        while (!commands.equals("END")) {
            String[] currentCommand = commands.split("\\s+");
            if (!validateCommand(commands, rows, columns)) {
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(currentCommand[1]);
                int col1 = Integer.parseInt(currentCommand[2]);
                int row2 = Integer.parseInt(currentCommand[3]);
                int col2 = Integer.parseInt(currentCommand[4]);
                matrix = changeMatrix(row1, col1, row2, col2, matrix);
                printMatrix(matrix);
            }
            commands = scanner.nextLine();
        }
    }

    private static boolean validateCommand(String commands, int rows, int columns) {
        String[] commandParts = commands.split("\\s+"); // ["swap", "2", "3", "4", "5"]

        //1. започва със swap
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        //2. има определен брой части
        if (commandParts.length != 5) {
            return false;
        }
        //3. проверка дали координатите са вътре в матрицата
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0
                || row2 >= rows || col1 < 0 || col1 >= columns
                || col2 < 0 || col2 > columns) {
            return false;
        }

        return true;
    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBound(int row1, int col1, int row2, int col2, int rows, int columns) {
        return (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows
                || col1 < 0 || col1 >= columns || col2 < 0 || col2 >= columns);
    }

    private static String[][] changeMatrix(int row1, int col1, int row2, int col2, String[][] matrix) {
        String currentFirstNum = "";
        String currentSecondNum = "";

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (r == row1 && c == col1) {
                    currentFirstNum = matrix[r][c];
                }
                if (r == row2 && c == col2) {
                    currentSecondNum = matrix[r][c];
                }
            }
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (r == row1 && c == col1) {
                    matrix[r][c] = currentSecondNum;
                }
                if (r == row2 && c == col2) {
                    matrix[r][c] = currentFirstNum;
                }
            }
        }
        return matrix;
    }

    private static String[][] fillStringMatrix(int rows, Scanner scanner) {
        String[][] matrix = new String[rows][];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}
