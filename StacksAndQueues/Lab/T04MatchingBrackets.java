package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char tempChar = input.charAt(i);
            if (tempChar == '(') {
                stack.push(i);
            } else if (tempChar == ')') {
                int startIndex = stack.pop();
                String content = input.substring(startIndex, i + 1);
                System.out.println(content);
            }
        }

    }
}
