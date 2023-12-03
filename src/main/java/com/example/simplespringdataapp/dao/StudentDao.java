package com.example.simplespringdataapp.dao;

import com.example.simplespringdataapp.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student student);
    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student student);


    void delete(Integer id);

    void deleteAll();
}
