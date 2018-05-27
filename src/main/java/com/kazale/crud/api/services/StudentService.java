package com.kazale.crud.api.services;

import java.util.List;

import com.kazale.crud.api.documents.Student;
import com.kazale.crud.api.exception.EmployeeServiceException;

public interface StudentService {
	
	List<Student> getAllStudents();
	
	Student getStudentById(String id);
	
	Student addStudent(Student student);
	
	Student updateStudent(Student student)throws EmployeeServiceException;
	
	void removeStudent(String id);

}
