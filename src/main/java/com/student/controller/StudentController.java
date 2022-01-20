package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.example.demo.entity.User;
//import com.example.demo.entity.User;
import com.student.entity.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
private StudentService stuservice;
	

	@PostMapping("/adduser")
	public Student addUser(@RequestBody Student user) {

		return stuservice.createStudent(user);
	}
	
	@PostMapping("/addusers")
	public List<Student> addUsers(@RequestBody List<Student> users) {
		return stuservice.createStudents(users);
	}

	@GetMapping("/user/{id}")
	public Student getUserById(@PathVariable int id) {

		return stuservice.getStudentById(id);
	}

	@GetMapping("/users")
	public List<Student> getAllUsers() {
		return stuservice.getStudents();
	}

	@PutMapping("/updateuser")
	public Student updateUser(@RequestBody Student u) {
		return stuservice.updateStudent(u);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		return stuservice.deleteUser(id);
	}



}
