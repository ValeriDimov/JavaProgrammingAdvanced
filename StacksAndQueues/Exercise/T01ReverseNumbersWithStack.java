package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (String num : input) {
            stack.push(num);
        }
        for (String el : stack) {
            System.out.print(stack.pop() + " ");
        }

    }
}
