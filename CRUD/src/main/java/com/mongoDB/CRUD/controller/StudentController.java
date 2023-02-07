package com.mongoDB.CRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongoDB.CRUD.model.Student;
import com.mongoDB.CRUD.repository.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	private StudentRepo repository;

	
/*	
  	http://localhost:8010/addStudent 
	{
		   "stuId":,
		   "firstName":"",
		   "lastName":"",
		   "email":""
	}
*/
	@PostMapping("/addStudent")
	public String saveStudent(@RequestBody Student student) {
		repository.save(student);
		return "added student with id:" + student.getStuId();
	}

//	http://localhost:8010/findAllStudents
	@GetMapping("/findAllStudents")
	public List<Student> getStudents() {
		return repository.findAll();
	}

//	http://localhost:8010/findStudent/{StudentId}
	@GetMapping("/findStudent/{StudentId}")
	public Optional<Student> getStudent(@PathVariable int StudentId) {
		return repository.findById(StudentId);
	}
	
//	http://localhost:8010/delete/{StudentId}
	@DeleteMapping("/delete/{StudentId}")
	public String deleteStudent(@PathVariable int StudentId) {
		repository.deleteById(StudentId);
		return "Studnt deleted of id: " + StudentId;
	}
	
//	http://localhost:8010/updateStudent
	@PutMapping("/updateStudent")
	public Student updateStudent(@RequestBody Student currStudent) {
		Student upStudent=repository.findById(currStudent.getStuId()).get();
		upStudent.setFirstName(currStudent.getFirstName());
		upStudent.setLastName(currStudent.getLastName());
		upStudent.setEmail(currStudent.getEmail());
		return repository.save(upStudent);		
	}
}
