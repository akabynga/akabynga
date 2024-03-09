package com.akabynga;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Find two students over 20 y.o. who have the highest GPA (Grade Point Average)
//
//@Data
//class Student {
//    private int id,
//    private String name;
//    private int age;
//    private double average;
//    }





//Tables:

//readers(id, name)
//writers(id, name, idReader)

// select * from readers;
// select * from readers where name = 'Петя';
// select * from readers where name like 'П%'
// UNION
// select * from readers where name like 'п%';
//
// select w.* from writers w where idReader = (select id from readers where name = 'Петя')

// select w.* from writers w
// JOIN readers r on w.idReader = r.id and r.name = 'Петя'



public class App {


    public static void main(String[] args) {

    }

    public List<Student> getHighestGPAStudents(final Student[] students) {
        if (students == null) {
            return Collections.emptyList();
        }
        return getHighestGPAStudents(Arrays.stream(students).toList());
    }

    public List<Student> getHighestGPAStudents(final List<Student> students) {

        if (students == null) {
            return Collections.emptyList();
        }
        return students.stream()
                .filter(s -> s.age > 20)
                .sorted()
                .limit(2)
                .toList();
    }

    class Student {
        private int id;
        private String name;
        private int age;
        private double average;
    }
}
