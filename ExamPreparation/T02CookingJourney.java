package ExamPreparation;

import java.util.Scanner;

public class T02CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int r = 0; r < matrix.length; r++) {
            String input = scanner.nextLine();
            matrix[r] = input.toCharArray();
        }
        char sellerPosition = 'S';
        char pillarPosition = 'P';
        int rowPosition = getRowPosition(matrix, sellerPosition);
        int rowInitialSellerPosition = rowPosition;
        int colPosition = getColPosition(matrix, sellerPosition);
        int colInitialSellerPosition = colPosition;
        int totalMoney = 0;
        boolean isInBound = isOut(rowPosition, colPosition, size);

        while (totalMoney < 50 && isInBound) {
            String command = scanner.nextLine();
            int secondPillarRow = -1;
            int secondPillarCol = -1;
            switch (command) {
                case "up":
                    rowPosition -= 1;
                    isInBound = isOut(rowPosition, colPosition, size);
                    if (!isInBound) {
                        break;
                    }
                    if (Character.isDigit(matrix[rowPosition][colPosition])) {
                        totalMoney += Integer.parseInt(String.valueOf(matrix[rowPosition][colPosition]));
                        matrix[rowPosition][colPosition] ='-';
                    }
                    if (matrix[rowPosition][colPosition] == 'P') {
                        matrix[rowPosition][colPosition] = '-';
                        secondPillarRow = getRowPosition(matrix, pillarPosition);
                        secondPillarCol = getColPosition(matrix, pillarPosition);
                        matrix[secondPillarRow][secondPillarCol] = '-';
                        rowPosition = secondPillarRow;
                        colPosition = secondPillarCol;
                    }
                    break;
                case "down":
                    rowPosition += 1;
                    isInBound = isOut(rowPosition, colPosition, size);
                    if (!isInBound) {
                        break;
                    }
                    if (Character.isDigit(matrix[rowPosition][colPosition])) {
                        totalMoney += Integer.parseInt(String.valueOf(matrix[rowPosition][colPosition]));
                        matrix[rowPosition][colPosition] ='-';
                    }
                    if (matrix[rowPosition][colPosition] == 'P') {
                        matrix[rowPosition][colPosition] = '-';
                        secondPillarRow = getRowPosition(matrix, pillarPosition);
                        secondPillarCol = getColPosition(matrix, pillarPosition);
                        matrix[secondPillarRow][secondPillarCol] = '-';
                        rowPosition = secondPillarRow;
                        colPosition = secondPillarCol;
                    }
                    break;
                case "left":
                    colPosition -= 1;
                    isInBound = isOut(rowPosition, colPosition, size);
                    if (!isInBound) {
                        break;
                    }
                    if (Character.isDigit(matrix[rowPosition][colPosition])) {
                        totalMoney += Integer.parseInt(String.valueOf(matrix[rowPosition][colPosition]));
                        matrix[rowPosition][colPosition] ='-';
                    }
                    if (matrix[rowPosition][colPosition] == 'P') {
                        matrix[rowPosition][colPosition] = '-';
                        secondPillarRow = getRowPosition(matrix, pillarPosition);
                        secondPillarCol = getColPosition(matrix, pillarPosition);
                        matrix[secondPillarRow][secondPillarCol] = '-';
                        rowPosition = secondPillarRow;
                        colPosition = secondPillarCol;
                    }
                    break;
                case "right":
                    colPosition += 1;
                    isInBound = isOut(rowPosition, colPosition, size);
                    if (!isInBound) {
                        break;
                    }
                    if (Character.isDigit(matrix[rowPosition][colPosition])) {
                        totalMoney += Integer.parseInt(String.valueOf(matrix[rowPosition][colPosition]));
                        matrix[rowPosition][colPosition] ='-';
                    }
                    if (matrix[rowPosition][colPosition] == 'P') {
                        matrix[rowPosition][colPosition] = '-';
                        secondPillarRow = getRowPosition(matrix, pillarPosition);
                        secondPillarCol = getColPosition(matrix, pillarPosition);
                        matrix[secondPillarRow][secondPillarCol] = '-';
                        rowPosition = secondPillarRow;
                        colPosition = secondPillarCol;
                    }
                    break;
            }
            if (!isInBound) {
                System.out.println("Bad news! You are out of the pastry shop.");
                System.out.printf("Money: %d%n", totalMoney);
                matrix[rowInitialSellerPosition][colInitialSellerPosition] = '-';
                printMatrix(matrix);
                break;
            }
        }
        if (totalMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.printf("Money: %d%n", totalMoney);
            matrix[rowInitialSellerPosition][colInitialSellerPosition] = '-';
            matrix[rowPosition][colPosition] = 'S';
            printMatrix(matrix);
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (Character.isDigit(matrix[r][c])) {
                    System.out.print(Integer.parseInt(String.valueOf(matrix[r][c])));
                } else {
                    System.out.print(matrix[r][c]);
                }
            }
            System.out.println();
        }
    }

    private static boolean isOut(int rowPosition, int colPosition, int size) {
        return rowPosition >= 0 && rowPosition < size && colPosition >= 0 && colPosition < size;
    }

    private static int getRowPosition(char[][] matrix, char positionSymbol) {
        int rowPosition = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == positionSymbol) {
                    rowPosition = r;
                }
            }
        }
        return rowPosition;
    }

    private static int getColPosition(char[][] matrix, char positionSymbol) {
        int rowPosition = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == positionSymbol) {
                    rowPosition = c;
                }
            }
        }
        return rowPosition;
    }
}
