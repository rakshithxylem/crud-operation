package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
private StudentRepository studentrepository;
	
	public Student createStudent(Student s) {
		return studentrepository.save(s);
	}
	
	public List<Student> createStudents(List<Student> s){
		return studentrepository.saveAll(s);
	}
	
	public Student getStudentById(int i) {
		return studentrepository.findById(i).orElse(null);
	}
	
	public List<Student> getStudents(){
		return studentrepository.findAll();
	}
	
	public Student updateStudent(Student s) {
		Optional<Student> optnuser=studentrepository.findById(s.getId());
		Student stu=null;
		
		if(optnuser.isPresent()) {
			stu=optnuser.get();
			stu.setAddress(s.getAddress());
			stu.setName(s.getName());
			studentrepository.save(stu);
		}else {
			return new Student();
		}
		return stu;
		}
	
	public String deleteUser(int id) {

	studentrepository.deleteById(id);
		return "user got deleted";
	}
	
	
	}
	

