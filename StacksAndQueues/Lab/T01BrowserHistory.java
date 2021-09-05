package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class T01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String url = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!url.equals("Home")) {
            if (!url.equals("back")) {
                stack.push(url);
                System.out.println(stack.peek());
            } else {
                if (stack.size() > 1) {
                    stack.pop();
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }

            url = scanner.nextLine();
        }

    }
}
