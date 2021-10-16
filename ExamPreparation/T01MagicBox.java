package ExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class T01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstBoxItems = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondBoxItems = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Deque<Integer> queue = new ArrayDeque<>();
        for (Integer firstBoxItem : firstBoxItems) {
            queue.offer(firstBoxItem);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (Integer secondBoxItem : secondBoxItems) {
            stack.push(secondBoxItem);
        }

        List<Integer> myCollectionOfItems = new ArrayList<>();

        while (stack.size() > 0 && queue.size() > 0) {
            int currentQueueNum = queue.peek();
            int currentStackNum = stack.peek();
            if ((currentQueueNum + currentStackNum) % 2 == 0) {
                myCollectionOfItems.add(stack.peek() + queue.peek());
                stack.pop();
                queue.poll();
            } else {
                int stackNum = stack.pop();
                queue.offer(stackNum);
            }
        }
        if (queue.size() == 0) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        int totalSum = 0;
        for (Integer myCollectionOfItem : myCollectionOfItems) {
            totalSum += myCollectionOfItem;
        }
        if (totalSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", totalSum);
        } else {
            System.out.printf("Poor prey... Value: %d", totalSum);
        }
    }
}
