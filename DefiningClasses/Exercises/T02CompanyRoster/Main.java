package DefiningClasses.Exercises.T02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String currentDepartment = input[3];

            Employee employee = null;

            if (input.length == 6) {
                String email = input[4];
                int age = Integer.parseInt(input[5]);
                employee = new Employee(name, salary, position, currentDepartment, email, age);
            } else if (input.length == 4) {
                employee = new Employee(name, salary, position, currentDepartment);
            } else if (input.length == 5) {
                try {
                    int age = Integer.parseInt(input[4]);
                    employee = new Employee(name, salary, position, currentDepartment, age);
                } catch (NumberFormatException e) {
                    String email = input[4];
                    employee = new Employee(name, salary, position, currentDepartment, email);
                }
            }
            departments.putIfAbsent(currentDepartment, new Department(currentDepartment, new ArrayList<>()));
            departments.get(currentDepartment).getEmployees().add(employee);
        }
        Department highestAvgSalaryDep = departments
                .entrySet()
                .stream()
                .max(Comparator.comparing(e -> e.getValue().calculatesAvgSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + highestAvgSalaryDep.toPrintHighestAvgSalaryDep());

        highestAvgSalaryDep.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);

    }
}
