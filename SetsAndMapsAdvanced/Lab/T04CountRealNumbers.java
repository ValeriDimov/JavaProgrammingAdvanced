package SetsAndMapsAdvanced.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> numsMap = new LinkedHashMap<>();

        Arrays.stream(input).forEach(el -> {
            if (!numsMap.containsKey(el)) {
                numsMap.put(el, 1);
            }else {
                int tempNum = numsMap.get(el);
                numsMap.put(el, tempNum + 1);
            }
        });
        numsMap.entrySet().forEach(entry -> {
            System.out.printf("%.1f", entry.getKey());
            System.out.print(" -> ");
            System.out.println(entry.getValue());
        });
    }
}
