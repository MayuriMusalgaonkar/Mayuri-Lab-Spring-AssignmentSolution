package com.greatlearning.CollegeFestEvent.service;

import java.util.List;


import com.greatlearning.CollegeFestEvent.entity.Student;
import com.greatlearning.CollegeFestEvent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Implementation of the service methods
@Service
public class StudentServiceImpl implements StudentService {

@Autowired
private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		return studentRepository.getById(id);
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}
}
