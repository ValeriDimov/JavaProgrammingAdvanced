package SetsAndMapsAdvanced.Lab;

import java.util.*;

public class T05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsAndAppraisals = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] studentsArray = scanner.nextLine().split("\\s+");
            String studentName = studentsArray[0];
            double appraisal = Double.parseDouble(studentsArray[1]);

            if (!studentsAndAppraisals.containsKey(studentName)) {
                studentsAndAppraisals.put(studentName, new ArrayList<>());
                studentsAndAppraisals.get(studentName).add(appraisal);
            } else {
                studentsAndAppraisals.get(studentName).add(appraisal);
            }
        }
        studentsAndAppraisals.entrySet().forEach(stringListEntry -> {
            System.out.print(stringListEntry.getKey() + " -> ");
            double averageGrade = 0;
            for (Double grade : stringListEntry.getValue()) {
                averageGrade += grade;
                System.out.printf("%.2f ", grade);
            }
            averageGrade = averageGrade / stringListEntry.getValue().size();
            System.out.printf("(avg: %.2f)%n", averageGrade);
        });
    }
}
