package com.glearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glearning.dao.StudentRepository;
import com.glearning.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> fetchAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> searchAllStudent(String firstName , String lastName) {
		return studentRepository
				.findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(firstName,lastName);
	}

	@Override
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

}
