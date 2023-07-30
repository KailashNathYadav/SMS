package com.glearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glearning.model.Student;
import com.glearning.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public String getAllStudent(Model model) {
		List<Student> students = studentService.fetchAllStudent();
		model.addAttribute("students",students);
		return "students";
	}
	
	@PostMapping("/students/search")
	public String searchAllStudent(Model model
			,@RequestParam("keyword") String query) {
		List<Student> feasibleStudents = studentService.searchAllStudent(query,query);
		model.addAttribute("students",feasibleStudents);
		return "students";
	}
	
	@GetMapping("/students/newStudent")
	public String createStudentForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("create", true);
		return "create_or_edit_student";
	}

	@GetMapping("/students/edit/{id}")
	public String editTicketForm(@PathVariable int id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("student", student);
		model.addAttribute("create", false);
		studentService.deleteStudentById(id);
		return "create_or_edit_student";
	}

	@PostMapping("/students")
	public String save(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
