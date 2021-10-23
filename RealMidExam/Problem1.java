package RealMidExam;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] freshness = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);

        Deque<Integer> ingredientsQueue = new ArrayDeque<>();
        for (int ingredient : ingredients) {
            ingredientsQueue.offer(ingredient);
        }
        Deque<Integer> freshnessStack = new ArrayDeque<>();
        for (int i : freshness) {
            freshnessStack.push(i);
        }
        while (!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()) {
            int currentIngredient = ingredientsQueue.peek();
            if (currentIngredient == 0) {
                ingredientsQueue.poll();
                continue;
            }
            int currentFreshness = freshnessStack.peek();
            int multiply = currentIngredient * currentFreshness;

            switch (multiply) {
                case 150:
                    int currentNumOfPears = cocktails.get("Pear Sour");
                    cocktails.put("Pear Sour", currentNumOfPears + 1);
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                    break;
                case 250:
                    int currentNumOfHarvests = cocktails.get("The Harvest");
                    cocktails.put("The Harvest", currentNumOfHarvests + 1);
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                    break;
                case 300:
                    int currentNumOfApples = cocktails.get("Apple Hinny");
                    cocktails.put("Apple Hinny", currentNumOfApples + 1);
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                    break;
                case 400:
                    int currentNumOfFashions = cocktails.get("High Fashion");
                    cocktails.put("High Fashion", currentNumOfFashions + 1);
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                    break;
                default:
                    freshnessStack.pop();
                    currentIngredient += 5;
                    ingredientsQueue.poll();
                    ingredientsQueue.offer(currentIngredient);
                    break;
            }
        }
        boolean isCocktailEmpty = false;
        for (Map.Entry<String, Integer> entry : cocktails.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println("What a pity! You didn't manage to prepare all cocktails.");
                isCocktailEmpty = true;
                break;
            }
        }
        if (!isCocktailEmpty) {
            System.out.println("It's party time! The cocktails are ready!");
        }
        if (!ingredientsQueue.isEmpty()) {
            int sumOfIngredients = 0;
            while (!ingredientsQueue.isEmpty()) {
                sumOfIngredients += ingredientsQueue.poll();
            }
            System.out.printf("Ingredients left: %d%n", sumOfIngredients);
        }
        cocktails.entrySet().forEach(c -> {
            if (c.getValue() > 0) {
                System.out.printf("# %s --> %d%n", c.getKey(), c.getValue());
            }
        });
    }
}
