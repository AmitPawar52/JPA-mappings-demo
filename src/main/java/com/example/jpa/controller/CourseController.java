package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Instructor;
import com.example.jpa.entity.Review;
import com.example.jpa.repository.CourseRepository;
import com.example.jpa.repository.InstructorRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
	
	@PostMapping("/instructor/{id}/courses")
	public Course addCourse(@PathVariable("id") int id, @RequestBody Course course) {
		Instructor instructor = instructorRepository.getById(id);
		course.setInstructor(instructor);
		return courseRepository.save(course);
	}
	
	@GetMapping("/courses/{id}")
	public Course getCourse(@PathVariable("id") int id) {
		return courseRepository.getById(id);
	}
	
	@PostMapping("/courses/{id}/reviews")
	public Course addReview(@PathVariable("id") int id, @RequestBody Review review) {
		Course course = courseRepository.getById(id);
		course.getReviews().add(review);
		return courseRepository.save(course); 
	}
}
