package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        if (students.size() < capacity) {
            if (!students.contains(student)) {
                students.add(student);
                return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                return "Student is already in the university";
            }
        } else {
            return "No seats in the university";
        }
    }

    public String dismissStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public String getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student.toString();
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        //o	"==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
        // ==Student: First Name = {firstName}, Last Name = {lastName}, Best Subject = {bestSubject}
        students.forEach(s -> {
            sb.append("==Student: First Name = ").append(s.getFirstName()).append(", Last Name = ")
                    .append(s.getLastName()).append(", Best Subject = ").append(s.getBestSubject())
                    .append(System.lineSeparator());
        });
        return sb.toString().trim();
    }
}
