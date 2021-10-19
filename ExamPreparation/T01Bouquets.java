package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class T01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tulipsArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] daffodilsArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> tulipsStack = new ArrayDeque<>();
        for (int f : tulipsArr) {
            tulipsStack.push(f);
        }
        Deque<Integer> daffodilsQueue = new ArrayDeque<>();
        for (int f : daffodilsArr) {
            daffodilsQueue.offer(f);
        }
        int bouquetsCount = 0;
        int storedFlowers = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int currentTulip = tulipsStack.peek();
            int currentDaffodil = daffodilsQueue.peek();

            if (currentTulip + currentDaffodil == 15) {
                bouquetsCount += 1;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else if (currentTulip + currentDaffodil > 15) {
                int flowersSum = (currentTulip + currentDaffodil);
                while (flowersSum > 15) {
                    currentTulip -= 2;
                    flowersSum = (currentTulip + currentDaffodil);
                    if (flowersSum == 15) {
                        bouquetsCount += 1;
                        tulipsStack.pop();
                        daffodilsQueue.poll();
                        break;
                    } else if (flowersSum < 15) {
                        storedFlowers += flowersSum;
                        tulipsStack.pop();
                        daffodilsQueue.poll();
                    }
                }

            } else {
                storedFlowers += (currentTulip + currentDaffodil);
                tulipsStack.pop();
                daffodilsQueue.poll();
            }

        }
        bouquetsCount += storedFlowers / 15;
        if (bouquetsCount < 5) {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquetsCount);
        } else {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquetsCount);
        }

    }
}
