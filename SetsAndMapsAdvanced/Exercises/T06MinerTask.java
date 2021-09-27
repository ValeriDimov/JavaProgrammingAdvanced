package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class T06MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resourceOrQuantity = scanner.nextLine();
        Map<String, Integer> resourcesMap = new LinkedHashMap<>();
        List<String> dataList = new ArrayList<>();

        while (!resourceOrQuantity.equals("stop")) {
            dataList.add(resourceOrQuantity);
            resourceOrQuantity = scanner.nextLine();
        }
        for (int i = 0; i < dataList.size() - 1; i++) {
            if (i % 2 == 0) {
                if (!resourcesMap.containsKey(dataList.get(i))) {
                    resourcesMap.put(dataList.get(i), Integer.parseInt(dataList.get(i + 1)));
                } else {
                    int currentQuantity = resourcesMap.get(dataList.get(i));
                    resourcesMap.put(dataList.get(i), currentQuantity + Integer.parseInt(dataList.get(i + 1)));
                }
            }
        }
        resourcesMap.entrySet().forEach(el -> System.out.printf("%s -> %d%n", el.getKey(), el.getValue()));
    }
}
