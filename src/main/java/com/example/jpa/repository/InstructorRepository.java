package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jpa.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
