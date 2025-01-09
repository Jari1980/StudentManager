package org.example.service;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    private final StudentDao studentDao;
    private final UserInputService userInputService;
    private final Scanner scanner;

    @Autowired
    public StudentManagementConsoleImpl(StudentDao studentDao, UserInputService userInputService, Scanner scanner) {
        this.studentDao = studentDao;
        this.userInputService = userInputService;
        this.scanner = scanner;
    }

    @Override
    public Student create() {
        System.out.println("Enter student name: ");
        var name = scanner.nextLine();
        System.out.println("Enter student id: ");
        var id = scanner.nextInt();
        scanner.nextLine();

        return new Student(id, name);
    }

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {
        return studentDao.find(id);
    }

    @Override
    public Student remove(int id) {
        Student student = find(id);
        studentDao.delete(id);

        return student;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {
        studentDao.find(student.getId()).setName(student.getName());

        return studentDao.find(student.getId());
    }
}
