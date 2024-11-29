package com.example.cruddemo1.DAO;

import com.example.cruddemo1.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student studentDAO);

    Student findById(int id);

    List<Student> getAllStudents();

    List<Student> getStudentByLastName(String lastName);

    void updateStudent(Student student);

    void deleteStudent(Integer id);

    int deleteAll();
}
