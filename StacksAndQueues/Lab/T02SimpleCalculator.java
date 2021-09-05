package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("\\s+");

        int result = 0;

        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                result = Integer.parseInt(input[i]);
                stack.push(result);
            }
            if ((input[i].equals("+"))) {
                result += Integer.parseInt(input[i + 1]);
                stack.push(result);
            } else if ((input[i].equals("-"))) {
                result -= Integer.parseInt(input[i + 1]);
                stack.push(result);
            }
        }
        System.out.println(stack.peek());
    }
}
