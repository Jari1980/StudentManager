package org.example;

import org.example.config.ComponentScanConfig;
import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.service.StudentManagement;
import org.example.util.UserInputService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService =context.getBean(UserInputService.class);


        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        Student stud1 = studentManagement.create();
        studentManagement.save(stud1);
        Student stud2 = studentManagement.create();
        studentManagement.save(stud2);
        System.out.println("-----------");
        List<Student> list = studentManagement.findAll();

        for (Student student : list) {
            System.out.println(student.getName());
        }
    }
}