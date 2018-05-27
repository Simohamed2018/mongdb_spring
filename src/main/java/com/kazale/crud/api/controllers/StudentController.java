package com.kazale.crud.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.kazale.crud.api.exception.EmployeeServiceException;
import com.kazale.crud.api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kazale.crud.api.documents.Student;
import com.kazale.crud.api.responses.Response;
import com.kazale.crud.api.services.StudentService;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<Response<List<Student>>> ListStudents() {
		return ResponseEntity.ok(new Response<List<Student>>(this.studentService.getAllStudents()));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Student>> listarPorId(@PathVariable(name = "id") String id) throws ResourceNotFoundException ,EmployeeServiceException {
		Student student = studentService.getStudentById(id);

		if (student == null) {
			throw new ResourceNotFoundException("Simo Student not found with id :  "+id);
		}

		return ResponseEntity.ok(new Response<Student>(this.studentService.getStudentById(id)));
	}
	
	@PostMapping
	public ResponseEntity<Response<Student>> addStudent(@Valid @RequestBody Student student, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Student>(erros));
		}


		return ResponseEntity.ok(new Response<Student>(this.studentService.addStudent(student)));
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Student>> update(@PathVariable(name = "id") String id, @Valid @RequestBody Student student, BindingResult result)
														throws ResourceNotFoundException ,EmployeeServiceException {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Student>(erros));
		}
		try {
		Student studentExiste = studentService.getStudentById(id);

		if (studentExiste == null) {
			throw new ResourceNotFoundException("Simo Student not found with id :  "+id);
		}

		student.setId(id);

		return ResponseEntity.ok(new Response<Student>(this.studentService.updateStudent(student)));

	} catch (EmployeeServiceException e) {
		throw new EmployeeServiceException("Simo Internal Server Exception while getting exception");
	}
	}

	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> delete(@PathVariable(name = "id") String id) {
		this.studentService.removeStudent(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}

}
