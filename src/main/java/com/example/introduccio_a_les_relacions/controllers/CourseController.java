package com.example.introduccio_a_les_relacions.controllers;

import com.example.introduccio_a_les_relacions.entity.Course;
import com.example.introduccio_a_les_relacions.entity.CourseMaterial;
import com.example.introduccio_a_les_relacions.repositoris.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course")

public class CourseController {
    @Autowired //per instanciar automaticament cuan sigui necesari
    CoursesRepository courseRep;

    @GetMapping("")
    public ResponseEntity<?> llistatCourses() {
        List<Course> courses = courseRep.findAll();
        if (courses.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(courses);
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<?> llistatCoursesId(@PathVariable Long id) {
        Course course = courseRep.findById(id).get();

        if (courseRep.findById(id).isPresent()) {
            return ResponseEntity.ok(course);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

}