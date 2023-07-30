package com.glearning.service;

import java.util.List;

import com.glearning.model.Student;

public interface StudentService {
	List<Student> fetchAllStudent();
	List<Student> searchAllStudent(String firstName,String lastName);
	Student getStudentById(int id);
	void saveStudent(Student student);
	void deleteStudentById(int id);
}
