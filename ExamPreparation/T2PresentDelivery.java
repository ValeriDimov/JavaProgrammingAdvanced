package ExamPreparation;

import java.util.Scanner;

public class T2PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presentsCount = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = fillMatrix(size, scanner);
        String command = scanner.nextLine();
        char santa = 'S';
        char naughtyKid = 'X';
        char niceKid = 'V';
        char cookies = 'C';

        int santaRowPosition = giveRowPosition(matrix, santa);
        int santaColPosition = giveColPosition(matrix, santa);
        int santaInitialRow = santaRowPosition;
        int santaInitialCol = santaColPosition;
        boolean isOut = false;
        int countNiceKids = 0;

        char symbol = ' ';

        while (!command.equals("Christmas morning")) {

            switch (command) {
                case "up":
                    if (santaRowPosition != 0) {
                        santaRowPosition -= 1;
                    } else {
                        System.out.println("Santa ran out of presents!");
                        isOut = true;
                    }
                    symbol = checkSymbol(matrix, santaRowPosition, santaColPosition);
                    if (symbol == niceKid) {
                        presentsCount -= 1;
                        countNiceKids += 1;
                        if (presentsCount == 0) {
                            isOut = true;
                            System.out.println("Santa ran out of presents!");
                        }
                        matrix[santaRowPosition][santaColPosition] = '-';
                    } else if (symbol == naughtyKid) {
                        matrix[santaRowPosition][santaColPosition] = '-';
                    }
                    //cookies
                    break;
                case "down":
                    if (santaRowPosition != size - 1) {
                        santaRowPosition += 1;
                    } else {
                        System.out.println("Santa ran out of presents!");
                        isOut = true;
                    }
                    symbol = checkSymbol(matrix, santaRowPosition, santaColPosition);
                    if (symbol == niceKid) {
                        presentsCount -= 1;
                        countNiceKids += 1;
                        if (presentsCount == 0) {
                            isOut = true;
                            System.out.println("Santa ran out of presents!");
                        }
                        matrix[santaRowPosition][santaColPosition] = '-';
                    } else if (symbol == naughtyKid) {
                        matrix[santaRowPosition][santaColPosition] = '-';
                    }
                    break;
                case "left":
                    if (santaColPosition != 0) {
                        santaColPosition -= 1;
                    } else {
                        System.out.println("Santa ran out of presents!");
                        isOut = true;
                    }
                    symbol = checkSymbol(matrix, santaRowPosition, santaColPosition);
                    if (symbol == niceKid) {
                        presentsCount -= 1;
                        countNiceKids += 1;
                        if (presentsCount == 0) {
                            isOut = true;
                            System.out.println("Santa ran out of presents!");
                        }
                        matrix[santaRowPosition][santaColPosition] = '-';
                    } else if (symbol == naughtyKid) {
                        matrix[santaRowPosition][santaColPosition] = '-';
                    }
                    break;
                case "right":
                    if (santaColPosition != size - 1) {
                        santaColPosition += 1;
                    } else {
                        System.out.println("Santa ran out of presents!");
                        isOut = true;
                    }
                    symbol = checkSymbol(matrix, santaRowPosition, santaColPosition);
                    if (symbol == niceKid) {
                        presentsCount -= 1;
                        countNiceKids += 1;
                        if (presentsCount == 0) {
                            isOut = true;
                            System.out.println("Santa ran out of presents!");
                        }
                        matrix[santaRowPosition][santaColPosition] = '-';
                    } else if (symbol == naughtyKid) {
                        matrix[santaRowPosition][santaColPosition] = '-';
                    }
                    break;
            }
            if (isOut) {
                break;
            }

            command = scanner.nextLine();
        }
        matrix[santaInitialRow][santaInitialCol] = '-';
        matrix[santaRowPosition][santaColPosition] = santa;
        printMatrix(matrix);
        int niceKidsLeft = countNKids(matrix, niceKid);
        if (niceKidsLeft == 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.", countNiceKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.", niceKidsLeft);
        }
    }

    private static int countNKids(char[][] matrix, char niceKid) {
        int countNiceKids = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == niceKid) {
                    countNiceKids++;
                }
            }
        }
        return countNiceKids;
    }

    private static char checkSymbol(char[][] matrix, int santaRowPosition, int santaColPosition) {
        char currentSymbol = ' ';
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                currentSymbol = matrix[santaRowPosition][santaColPosition];
            }
        }
        return currentSymbol;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }


    private static int giveColPosition(char[][] matrix, char santa) {
        int colPosition = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == santa) {
                    colPosition = c;
                }
            }
        }
        return colPosition;

    }

    private static int giveRowPosition(char[][] matrix, char santa) {
        int rowPosition = -1;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == santa) {
                    rowPosition = r;
                }
            }
        }
        return rowPosition;
    }

    private static char[][] fillMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < matrix.length; r++) {
            String[] strArr = scanner.nextLine().split("\\s+");
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = strArr[c].charAt(0);
            }
        }
        return matrix;
    }
}
