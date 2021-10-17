package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class T01OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] threads = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> tasksStack = new ArrayDeque<>();
        for (int i : tasks) {
            tasksStack.push(i);
        }
        Deque<Integer> threadsQueue = new ArrayDeque<>();
        for (int i : threads) {
            threadsQueue.offer(i);
        }

        int taskToKill = Integer.parseInt(scanner.nextLine());

        while (!tasksStack.isEmpty() && !threadsQueue.isEmpty()) {
            int currentTask = tasksStack.peek();
            int currentThread = threadsQueue.peek();

            if (currentTask == taskToKill) {
                System.out.printf("Thread with value %d killed task %d%n", currentThread, taskToKill);
                while (!threadsQueue.isEmpty()) {
                    System.out.print(threadsQueue.poll() + " ");
                }
                break;
            }

            if (currentThread >= currentTask) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }

        }

    }
}
