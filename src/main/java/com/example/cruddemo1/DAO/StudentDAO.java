package com.example.cruddemo1.DAO;

import com.example.cruddemo1.entity.Student;

public interface StudentDAO {
    void save(Student studentDAO);

    Student findById(int id);
}
