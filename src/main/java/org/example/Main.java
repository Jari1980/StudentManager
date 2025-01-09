package org.example;

import org.example.config.ComponentScanConfig;
import org.example.data_access.StudentDao;
import org.example.util.UserInputService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
        UserInputService userInputService =context.getBean(UserInputService.class);


        System.out.println("Broccoli!!");
    }
}