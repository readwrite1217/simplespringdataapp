package com.example.simplespringdataapp;

import com.example.simplespringdataapp.dao.StudentDao;
import com.example.simplespringdataapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SimplespringdataappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplespringdataappApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(String[] args) {
//        return runner -> {
//            System.out.println("Hello World");
//        };
//    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
//        return runner -> {
//            getStudentById(studentDao, 1);
//        };
        return runner -> {
            createStudent(studentDao);
        };

//        return runner -> {
//            createStudent(studentDao);
//        };
    }

    private void createStudent(StudentDao studentDao) {
        Student student = new Student("sahas", "sharma", "john.lenon@gmail.com");
        studentDao.save(student);
        System.out.println("Saved student. Generated Id: " + student.getId());
    }

    private void getStudentById(StudentDao studentDao, int id) {
        Student student = studentDao.findById(id);
        System.out.println("Retrieved student. Student Id: " + student.getId() + " ,Student Name: " + student.getFirstname() + " " + student.getLastname());
    }

    private void findAll(StudentDao studentDao) {
        List<Student> studentList = studentDao.findAll();
        for (Student st :
                studentList) {
            System.out.println(st);
        }
    }
    private void findByLastName(StudentDao studentDao, String theLastName) {
        List<Student> studentList = studentDao.findByLastName(theLastName);
        for (Student st :
                studentList) {
            System.out.println(st);
        }
    }

    private void update(StudentDao studentDao){
        int studentId = 2;
        Student student = studentDao.findById(studentId);
        student.setFirstname("Scoovy");
        studentDao.update(student);
        System.out.println(student);
    }

    private void delete(StudentDao studentDao){
        int studentId = 3;
        studentDao.delete(studentId);

    }
//    private void deleteAll(StudentDao studentDao){
//
//        studentDao.deleteAll();
//
//    }

}
