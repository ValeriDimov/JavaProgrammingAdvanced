package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        if (number == 0) {
            System.out.println(0);
        } else {
            while (number != 0) {
                stack.push(number % 2);
                number = number / 2;
            }
        }
        for (Integer element : stack) {
            System.out.print(stack.pop());
        }
    }
}
