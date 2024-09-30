package Controller;

import Entity.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class StudentController {
    public static List<Student> students;
    public StudentController(List<Student> student) {
        this.students = student;
    }

    public Optional<Student>  getYoungest(){
        Optional <Student> studentYoungest = students.stream()
                .min(Comparator.comparing(Student::getAge));
        return studentYoungest;
    }

    //Serch Student By name
//    public List<Student> searchStudent(String keyword) {
//        return students.stream()
//                .filter(student -> student.getName().contains(keyword))
//                .collect(Collectors.toList());
//    }

    public static List<Student> getByName(String keyword) {
        return students.stream()
                .filter(s->s.getName().contains(keyword))
                .toList();
    }
}
