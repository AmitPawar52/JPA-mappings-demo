package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Instructor;
import com.example.jpa.repository.InstructorRepository;

@RestController
public class InstructorController {

	@Autowired
	private InstructorRepository instructorRepository;
	
	@GetMapping("/instructors")
	public List<Instructor> getAllInstructors() {
		return instructorRepository.findAll();
	}
	
	@GetMapping("/instructors/{id}")
	public Instructor getInstructor(@PathVariable("id") int id) {
		return instructorRepository.getById(id);
	}
	
	@PostMapping("/instructors")
	public Instructor addInstructor(@RequestBody Instructor instructor) {
		if(instructor.getCourses()!=null) {
			instructor.getCourses().forEach(course -> course.setInstructor(instructor));
		}
		return instructorRepository.save(instructor);
	}
}
