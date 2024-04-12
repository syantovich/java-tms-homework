package org.syantovich;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Tom", true, 23, List.of(new String[]{"1", "2", "3"})));
        students.add(new Student("Alex", true, 19, List.of(new String[]{"программирование"})));
        students.add(new Student("Jane", false, 22, List.of(new String[]{"33", "222", "1133", "программирование"})));
        students.add(new Student("Ina", false, 12, List.of(new String[]{"423", "42342", "453", "программирование"})));


        System.out.println(Main.ageMoreThenTwenty(students));
        System.out.println(Main.lessThenTwoSubjects(students));
        System.out.println(Main.getStudentsProgramming(students));

    }

    static List<Student> ageMoreThenTwenty(List<Student> students) {
        List<Student> resultStudents = new ArrayList<Student>();
        for (Student student : students) {
            if(student.getAge() > 20){
                resultStudents.add(student);
            }
        }

        return resultStudents;
    }

    static List<Student> lessThenTwoSubjects(List<Student> students) {
        List<Student> resultStudents = new ArrayList<Student>();
        for (Student student : students) {
            if(student.getSubjects().size() < 2){
                resultStudents.add(student);
            }
        }

        return resultStudents;
    }

    static List<Student> getStudentsProgramming(List<Student> students) {
        List<Student> resultStudents = new ArrayList<Student>();
        for (Student student : students) {
            if(student.getSubjects().contains("программирование")){
                resultStudents.add(student);
            }
        }

        return resultStudents;
    }
}
