package RealMidExam;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int r = 0; r < matrix.length; r++) {
            char[] rowInputs = scanner.nextLine().toCharArray();
            matrix[r] = rowInputs;
        }
        int eatenCheese = 0;
        char mouse = 'M';
        int rowMousePosition = getRowPosition(matrix, mouse);
        int colMousePosition = getColPosition(matrix, mouse);
        int initialMouseRowPosition = rowMousePosition;
        int initialMouseColPosition = colMousePosition;
        String command = scanner.nextLine();
        boolean isOut = false;

        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    if (rowMousePosition > 0) {
                        rowMousePosition -= 1;
                    } else {
                        isOut = true;
                        break;
                    }
                    if (matrix[rowMousePosition][colMousePosition] == 'B') {
                        matrix[rowMousePosition][colMousePosition] = '-';
                        if (rowMousePosition > 0) {
                            rowMousePosition -= 1;
                        } else {
                            isOut = true;
                            break;
                        }
                    }
                    if (matrix[rowMousePosition][colMousePosition] == 'c') {
                        eatenCheese++;
                        matrix[rowMousePosition][colMousePosition] = '-';
                    }
                    break;
                case "down":
                    if (rowMousePosition < size - 1) {
                        rowMousePosition += 1;
                    } else {
                        isOut = true;
                        break;
                    }
                    if (matrix[rowMousePosition][colMousePosition] == 'B') {
                        matrix[rowMousePosition][colMousePosition] = '-';
                        if (rowMousePosition < size - 1) {
                            rowMousePosition += 1;
                        } else {
                            isOut = true;
                            break;
                        }
                    }
                    if (matrix[rowMousePosition][colMousePosition] == 'c') {
                        eatenCheese++;
                        matrix[rowMousePosition][colMousePosition] = '-';
                    }
                    break;
                case "left":
                    if (colMousePosition > 0) {
                        colMousePosition -= 1;
                    } else {
                        isOut = true;
                        break;
                    }
                    if (matrix[rowMousePosition][colMousePosition] == 'B') {
                        matrix[rowMousePosition][colMousePosition] = '-';
                        if (colMousePosition > 0) {
                            colMousePosition -= 1;
                        } else {
                            isOut = true;
                            break;
                        }
                    }
                    if (matrix[rowMousePosition][colMousePosition] == 'c') {
                        eatenCheese++;
                        matrix[rowMousePosition][colMousePosition] = '-';
                    }
                    break;
                case "right":
                    if (colMousePosition < size - 1) {
                        colMousePosition += 1;
                    } else {
                        isOut = true;
                        break;
                    }
                    if (matrix[rowMousePosition][colMousePosition] == 'B') {
                        matrix[rowMousePosition][colMousePosition] = '-';
                        if (colMousePosition < size - 1) {
                            colMousePosition += 1;
                        } else {
                            isOut = true;
                            break;
                        }
                    }
                    if (matrix[rowMousePosition][colMousePosition] == 'c') {
                        eatenCheese++;
                        matrix[rowMousePosition][colMousePosition] = '-';
                    }
                    break;
            }
            if (isOut) {
                System.out.println("Where is the mouse?");
                break;
            }

            command = scanner.nextLine();
        }

        matrix[initialMouseRowPosition][initialMouseColPosition] = '-';
        if (!isOut) {
            matrix[rowMousePosition][colMousePosition] = 'M';
        }
        String resultPrint = eatenCheese < 5 ? String.format("The mouse couldn't eat the cheeses, she needed %d cheeses more.", 5 - eatenCheese)
                : String.format("Great job, the mouse is fed %d cheeses!", eatenCheese);
        System.out.println(resultPrint);

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

    private static int getColPosition(char[][] matrix, char mouse) {
        int colPosition = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == mouse) {
                    colPosition = c;
                }
            }
        }
        return colPosition;
    }

    private static int getRowPosition(char[][] matrix, char mouse) {
        int rowPosition = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == mouse) {
                    rowPosition = r;
                }
            }
        }
        return rowPosition;
    }
}
