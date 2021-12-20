package com.greatlearning.CollegeFestEvent.service;



import com.greatlearning.CollegeFestEvent.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> findAll();

    Student findById(int id);

    void save(Student student);

    void deleteById(int id);
}
