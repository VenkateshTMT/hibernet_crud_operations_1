package com.example.cruddemo1.DAO;

import com.example.cruddemo1.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;


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

    @Override
    public List<Student> getAllStudents() {
        //creating JPQL query to get list of students
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);

        return theQuery.getResultList();
    }

    @Override
    public List<Student> getStudentByLastName(String lastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);

        theQuery.setParameter("theData",lastName);

        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }


    @Transactional
    @Override
    public void deleteStudent(Integer id) {
        Student student=entityManager.find(Student.class,id);
        entityManager.remove(student);
    }



    @Override
    @Transactional
    public int deleteAll() {
        int count=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return count;
    }

}
