package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> docsQueue = new ArrayDeque<>();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (docsQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + docsQueue.poll());
                }
            } else {
                docsQueue.offer(input);
            }
            input = scanner.nextLine();
        }
        for (String el : docsQueue) {
            System.out.println(el);
        }
    }
}
