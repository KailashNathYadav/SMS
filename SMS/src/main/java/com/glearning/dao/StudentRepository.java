package com.glearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	List<Student> findAllByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName,String lastName);
}
