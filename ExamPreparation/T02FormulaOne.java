package ExamPreparation;

import java.util.Scanner;

public class T02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int numberCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        matrix = fillMatrix(matrix, scanner);

        int rowPosition = giveRowPositon(matrix);
        int colPosition = giveColPositon(matrix);
        int initialRowP = rowPosition;
        int initialColP = colPosition;
        boolean isFinish = false;


        for (int i = 0; i < numberCommands; i++) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    if (rowPosition == 0) {
                        rowPosition = size - 1;
                    } else {
                        rowPosition -= 1;
                    }

                    if (isFieldFinish(rowPosition, colPosition, matrix)) {
                        System.out.println("Well done, the player won first place!");
                        matrix[rowPosition][colPosition] = 'P';
                        isFinish = true;
                    }

                    if (isFieldBonus(rowPosition, colPosition, matrix)) {
                        if (rowPosition == 0) {
                            rowPosition = size - 1;
                        } else {
                            rowPosition -= 1;
                        }
                    }
                    if (isFieldTrap(rowPosition, colPosition, matrix)) {
                        if (rowPosition == size - 1) {
                            rowPosition = 0;
                        } else {
                            rowPosition += 1;
                        }
                    }
                    break;
                case "down":
                    if (rowPosition == size - 1) {
                        rowPosition = 0;
                    } else {
                        rowPosition += 1;
                    }
                    if (isFieldFinish(rowPosition, colPosition, matrix)) {
                        System.out.println("Well done, the player won first place!");
                        matrix[rowPosition][colPosition] = 'P';
                        isFinish = true;
                    }

                    if (isFieldBonus(rowPosition, colPosition, matrix)) {
                        if (rowPosition == size - 1) {
                            rowPosition = 0;
                        } else {
                            rowPosition += 1;
                        }
                    }
                    if (isFieldTrap(rowPosition, colPosition, matrix)) {
                        if (rowPosition == 0) {
                            rowPosition = size - 1;
                        } else {
                            rowPosition -= 1;
                        }
                    }
                    break;

                case "left":
                    if (colPosition == 0) {
                        colPosition = size - 1;
                    } else {
                        colPosition -= 1;
                    }
                    if (isFieldFinish(rowPosition, colPosition, matrix)) {
                        System.out.println("Well done, the player won first place!");
                        matrix[rowPosition][colPosition] = 'P';
                        isFinish = true;
                    }
                    if (isFieldBonus(rowPosition, colPosition, matrix)) {
                        if (colPosition == 0) {
                            colPosition = size - 1;
                        } else {
                            colPosition -= 1;
                        }
                    }
                    if (isFieldTrap(rowPosition, colPosition, matrix)) {
                        if (colPosition == size - 1) {
                            colPosition = 0;
                        } else {
                            colPosition += 1;
                        }
                    }
                    break;
                case "right":
                    if (colPosition == size - 1) {
                        colPosition = 0;
                    } else {
                        colPosition += 1;
                    }
                    if (isFieldFinish(rowPosition, colPosition, matrix)) {
                        System.out.println("Well done, the player won first place!");
                        matrix[rowPosition][colPosition] = 'P';
                        isFinish = true;
                    }
                    if (isFieldBonus(rowPosition, colPosition, matrix)) {
                        if (colPosition == size - 1) {
                            colPosition = 0;
                        } else {
                            colPosition += 1;
                        }
                    }
                    if (isFieldTrap(rowPosition, colPosition, matrix)) {
                        if (colPosition == 0) {
                            colPosition = size - 1;
                        } else {
                            colPosition -= 1;
                        }
                    }
                    break;
            }
            if (isFinish) {
                break;
            }
        }
        if (!isFinish) {
            System.out.println("Oh no, the player got lost on the track!");
        }
        matrix[initialRowP][initialColP] = '.';
        matrix[rowPosition][colPosition] = 'P';
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static int giveRowPositon(char[][] matrix) {
        int rowPosition = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'P') {
                    rowPosition = r;
                }
            }
        }
        return rowPosition;
    }

    private static int giveColPositon(char[][] matrix) {
        int colPosition = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'P') {
                    colPosition = c;
                }
            }
        }
        return colPosition;
    }

    private static char[][] fillMatrix(char[][] matrix, Scanner scanner) {
        for (int r = 0; r < matrix.length; r++) {
            char[] matrixContent = scanner.nextLine().toCharArray();
            matrix[r] = matrixContent;
        }
        return matrix;
    }

    private static boolean isFieldFinish(int rowPosition, int colPosition, char[][] matrix) {
        return matrix[rowPosition][colPosition] == 'F';
    }

    private static boolean isFieldBonus(int rowPosition, int colPosition, char[][] matrix) {
        return matrix[rowPosition][colPosition] == 'B';
    }

    private static boolean isFieldTrap(int rowPosition, int colPosition, char[][] matrix) {
        return matrix[rowPosition][colPosition] == 'T';
    }
}
