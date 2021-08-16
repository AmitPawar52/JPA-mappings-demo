package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
