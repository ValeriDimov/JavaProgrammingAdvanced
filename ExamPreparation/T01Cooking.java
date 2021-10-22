package ExamPreparation;

import java.util.*;

public class T01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquids = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> productsMap = new LinkedHashMap<>();
        productsMap.put("Bread", 0);
        productsMap.put("Cake", 0);
        productsMap.put("Fruit Pie", 0);
        productsMap.put("Pastry", 0);

        Deque<Integer> liquidsQueue = new ArrayDeque<>();
        for (int liquid : liquids) {
            liquidsQueue.offer(liquid);
        }

        Deque<Integer> ingredientsStack = new ArrayDeque<>();
        for (int ingredient : ingredients) {
            ingredientsStack.push(ingredient);
        }

      while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()) {
            int currentLiquid = liquidsQueue.peek();
            int currentIngredient = ingredientsStack.peek();
            int sum = currentLiquid +currentIngredient;

            switch (sum) {
                case 25:
                    int currentNumBreads = productsMap.get("Bread");
                    productsMap.put("Bread", currentNumBreads + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 50:
                    int currentNumCakes = productsMap.get("Cake");
                    productsMap.put("Cake", currentNumCakes + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 75:
                    int currentNumPastries = productsMap.get("Pastry");
                    productsMap.put("Pastry", currentNumPastries + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                case 100:
                    int currentNumPies = productsMap.get("Fruit Pie");
                    productsMap.put("Fruit Pie", currentNumPies + 1);
                    liquidsQueue.poll();
                    ingredientsStack.pop();
                    break;
                default:
                    liquidsQueue.poll();
                    currentIngredient += 3;
                    ingredientsStack.pop();
                    ingredientsStack.push(currentIngredient);
                    break;
            }
      }
      boolean isWithFood = true;
        for (Map.Entry<String, Integer> entry : productsMap.entrySet()) {
            if (entry.getValue() == 0) {
                isWithFood = false;
                break;
            }
        }
        String firstLine = isWithFood ? "Wohoo! You succeeded in cooking all the food!" :
                "Ugh, what a pity! You didn't have enough materials to cook everything.";
        System.out.println(firstLine);

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: ");
            List<String> liquidsArr = new ArrayList<>();
            while (!liquidsQueue.isEmpty()) {
                liquidsArr.add(liquidsQueue.poll() +"");
            }
            System.out.println(String.join(", ", liquidsArr));
        }

        if (ingredientsStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: ");
            List<String> ingredientsArr = new ArrayList<>();
            while (!ingredientsStack.isEmpty()) {
                ingredientsArr.add(ingredientsStack.pop() +"");
            }
            System.out.println(String.join(", ", ingredientsArr));
        }
        productsMap.entrySet().forEach(p -> {
            System.out.print(p.getKey());
            System.out.print(": ");
            System.out.println(p.getValue());
        });
    }
}
