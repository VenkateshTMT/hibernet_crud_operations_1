package com.example.cruddemo1.DAO;

import com.example.cruddemo1.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Student studentDAO) {
        entityManager.persist(studentDAO);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

}
