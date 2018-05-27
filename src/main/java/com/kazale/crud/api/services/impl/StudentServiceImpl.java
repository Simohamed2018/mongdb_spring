package com.kazale.crud.api.services.impl;

import java.util.List;

import com.kazale.crud.api.exception.EmployeeServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kazale.crud.api.documents.Student;
import com.kazale.crud.api.repositories.StudentRepository;
import com.kazale.crud.api.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return this.studentRepository.findAll();
	}

	@Override
	public Student getStudentById(String id) {
		return this.studentRepository.findOne(id);
	}

	@Override
	public Student addStudent(Student student) {
		return this.studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) throws EmployeeServiceException {
		return this.studentRepository.save(student);
	}

	@Override
	public void removeStudent(String id) {
		this.studentRepository.delete(id);
	}

}
