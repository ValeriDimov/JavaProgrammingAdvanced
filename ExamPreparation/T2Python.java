package ExamPreparation;

import java.util.Scanner;

public class T2Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = loadMatrix(matrixSize, scanner);
        int pythonLength = 1;

        int rowPosition = startRow(matrix);
        int colPosition = startCol(matrix);

        int numberFood = numberFood(matrix);

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand) {
                case "left":
                    if (colPosition == 0) {
                        colPosition = matrix.length - 1;
                    } else {
                        colPosition = colPosition - 1;
                    }

                    if (matrix[rowPosition][colPosition] == 'f') {
                        numberFood -= 1;
                        pythonLength++;
                        if (numberFood == 0) {
                            System.out.printf("You win! Final python length is %d", pythonLength);
                            return;
                        }
                    }

                    if (matrix[rowPosition][colPosition] == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "right":
                    if (colPosition == matrix.length - 1) {
                        colPosition = 0;
                    } else {
                        colPosition = colPosition + 1;
                    }

                    if (matrix[rowPosition][colPosition] == 'f') {
                        numberFood -= 1;
                        pythonLength++;
                        if (numberFood == 0) {
                            System.out.printf("You win! Final python length is %d", pythonLength);
                            return;
                        }
                    }

                    if (matrix[rowPosition][colPosition] == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "up":
                    if (rowPosition == 0) {
                        rowPosition = matrixSize - 1;
                    } else {
                        rowPosition = rowPosition - 1;
                    }

                    if (matrix[rowPosition][colPosition] == 'f') {
                        numberFood -= 1;
                        pythonLength++;
                        if (numberFood == 0) {
                            System.out.printf("You win! Final python length is %d", pythonLength);
                            return;
                        }
                    }

                    if (matrix[rowPosition][colPosition] == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
                case "down":
                    if (rowPosition == matrixSize - 1) {
                        rowPosition = 0;
                    } else {
                        rowPosition = rowPosition + 1;
                    }

                    if (matrix[rowPosition][colPosition] == 'f') {
                        numberFood -= 1;
                        pythonLength++;
                        if (numberFood == 0) {
                            System.out.printf("You win! Final python length is %d", pythonLength);
                            return;
                        }
                    }

                    if (matrix[rowPosition][colPosition] == 'e') {
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
            }
        }
        System.out.printf("You lose! There is still %d food to be eaten.", numberFood);
    }

    private static int startRow(char[][] matrix) {
        int start = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 's') {
                    return start = row;
                }
            }
        }
        return 0;
    }

    private static int startCol(char[][] matrix) {
        int start = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 's') {
                    return start = col;
                }
            }
        }
        return 0;
    }

    private static char[][] loadMatrix(int matrixSize, Scanner scanner) {
        char[][] matrix = new char[matrixSize][matrixSize];
        for (int row = 0; row < matrixSize; row++) {
            String[] rowsElements = scanner.nextLine().split("\\s+");
            for (int column = 0; column < matrixSize; column++) {
                matrix[row][column] = rowsElements[column].charAt(0);
            }
        }
        return matrix;
    }

    private static int numberFood(char[][] matrix) {
        int numberFood = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'f') {
                    numberFood++;
                }
            }
        }
        return numberFood;
    }
}
