package university;

import com.sun.source.tree.IfTree;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students;
    private int capacity;

    public University(int capacity) {
        this.capacity = capacity;
        students = new ArrayList<>();
    }
    public int getCapacity(){
        return capacity;
    }
    public int getStudentCount(){
        return students.size();
    }
    public String registerStudent(Student student){
        if (students.contains(student)){
            return  "Student is already in the university";
        } else if (students.size()==capacity) {
            return "No seats in the university";
        }else {
            return String.format("Added student %S %s",student.getFirstName(),student.getLastName());
        }
    }
    public String dismissStudent(Student student){
        if (students.contains(student)){
            return  "Student not found";
        }

        students.removeIf(s -> s.getFirstName()==student.getFirstName());
        return null;
    }
    public Student getStudent(String firstName, String lastName){
        return students.stream()
                .filter(c -> c.getFirstName().equals(firstName)&& c.getLastName().equals(lastName))
                .findAny().orElse(null);
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        students.forEach(s->{
            sb.append(s.toString()).append(System.lineSeparator());
        });
        return sb.toString();
    }
}
