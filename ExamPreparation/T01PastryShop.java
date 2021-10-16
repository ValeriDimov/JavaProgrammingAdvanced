package ExamPreparation;

import java.util.*;

public class T01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquids = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        for (int liquid : liquids) {
            liquidsQueue.offer(liquid);
        }
        int[] ingredients = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> ingredientsStack = new ArrayDeque<>();
        for (int ingredient : ingredients) {
            ingredientsStack.push(ingredient);
        }

        Map<String, Integer> foodMap = new LinkedHashMap<>();
        foodMap.put("Biscuit", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pie", 0);
        foodMap.put("Pastry", 0);

        while (liquidsQueue.size() > 0 && ingredientsStack.size() > 0) {
            int liqValue = liquidsQueue.peek();
            int ingValue = ingredientsStack.peek();
            int sum = liqValue + ingValue;

            switch (sum) {
                case 25:
                    int bValue = foodMap.get("Biscuit");
                    foodMap.put("Biscuit", bValue + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 50:
                    int cValue = foodMap.get("Cake");
                    foodMap.put("Cake", cValue + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 75:
                    int paValue = foodMap.get("Pastry");
                    foodMap.put("Pastry",paValue + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 100:
                    int pieValue = foodMap.get("Pie");
                    foodMap.put("Pie",pieValue + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                default:
                    liquidsQueue.poll();
                    int tempIngredient = ingredientsStack.pop();
                    ingredientsStack.push(tempIngredient + 3);
                    break;
            }
        }

        if (foodMap.get("Biscuit") == 0 || foodMap.get("Cake") == 0
                || foodMap.get("Pastry") == 0 || foodMap.get("Pie") == 0) {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        } else {
            System.out.println("Great! You succeeded in cooking all the food!");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            List<String> leftLiquids = new ArrayList<>();
            for (Integer l : liquidsQueue) {
                leftLiquids.add(l + "");
            }
            System.out.printf("Liquids left: %s%n", String.join(", ", leftLiquids));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            List<String> leftIngredients = new ArrayList<>();
            for (Integer i : ingredientsStack) {
                leftIngredients.add(i + "");
            }
            System.out.printf("Ingredients left: %s%n", String.join(", ", leftIngredients));
        }
        foodMap.entrySet().forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));
    }
}
