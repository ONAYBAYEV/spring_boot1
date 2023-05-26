package bitlabspringboot.techorda.db;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DBManager {
    private static final  ArrayList<Student> students = new ArrayList<>();

    private static Long id = 6L;

    static {
        students.add(new Student(1L, "ASAN", "USEN", 89, "F"));
        students.add(new Student(2L, "Dias","Uabay", 65, "D"));
        students.add(new Student(3L, "Arsen", "Askerbek", 50, "C"));
        students.add(new Student(4L, "Hifumi", "ABE", 89, "A"));
        students.add(new Student(5L, "Shohei", "Ono", 65, "B"));
    }
    public static ArrayList<Student>getStudents(){
        return students;
    }
    public static void addStudent(Student student){
        student.setId(id);
        id++;
        students.add(student);

    }
}
