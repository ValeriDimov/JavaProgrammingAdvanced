package DefiningClasses.Exercises.T02CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String department;
    private List<Employee> employees;

    public Department(String department, List<Employee> employees) {
        this.department = department;
        this.employees = employees;
    }

    public String getDepartment() {
        return department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double calculatesAvgSalary() {
        return this.employees.stream().mapToDouble(e -> e.getSalary()).average().orElse(0);
    }


    public String toPrintHighestAvgSalaryDep() {
        return this.department;
    }
}
