package com.example.simplespringdataapp.dao;

import com.example.simplespringdataapp.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    private EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // since this is a db update , a transaction
    public void save(Student student) {
        entityManager.persist(student);

    }

    @Override
    @Transactional
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> findAll() {

        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student order by lastname", Student.class);
        List<Student> students = typedQuery.getResultList();
        return students;
    }

    @Override
    @Transactional
    public List<Student> findByLastName(String theLastName) {

        TypedQuery<Student> typedQuery = entityManager.createQuery("From Student WHERE lastname= :theData", Student.class);
        typedQuery.setParameter("theData", theLastName);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
//        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void deleteAll() {
        Query query = entityManager.createQuery("DELETE FROM Student");
        query.executeUpdate();
    }

}
