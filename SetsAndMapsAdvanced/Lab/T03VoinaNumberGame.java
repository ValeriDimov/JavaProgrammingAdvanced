package SetsAndMapsAdvanced.Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class T03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] cards1 = scanner.nextLine().split("\\s+");
        String[] cards2 = scanner.nextLine().split("\\s+");

        Set<Integer> playerOneCards = new LinkedHashSet<>();
        Set<Integer> playerTwoCards = new LinkedHashSet<>();

        for (int i = 0; i < 20; i++) {
            playerOneCards.add(Integer.parseInt(cards1[i]));
            playerTwoCards.add(Integer.parseInt(cards2[i]));
        }
        int rounds = 50;
        while (rounds-- > 0) {
            int topCard1 = playerOneCards.iterator().next();
            playerOneCards.remove(topCard1);
            int topCard2 = playerTwoCards.iterator().next();
            playerTwoCards.remove(topCard2);

            if (topCard1 > topCard2) {
                playerOneCards.add(topCard1);
                playerOneCards.add(topCard2);
            } else if (topCard2 > topCard1) {
                playerTwoCards.add(topCard2);
                playerTwoCards.add(topCard1);
            }
            if (playerOneCards.isEmpty()) {
                System.out.println("Second player win!");
                break;
            } else if (playerTwoCards.isEmpty()) {
                System.out.println("First player win!");
                break;
            }
        }
        if (playerOneCards.size() > playerTwoCards.size()) {
            System.out.println("First player win!");
        } else if (playerTwoCards.size() > playerOneCards.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
