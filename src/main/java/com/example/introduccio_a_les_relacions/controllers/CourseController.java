package com.example.introduccio_a_les_relacions.controllers;

import com.example.introduccio_a_les_relacions.entity.Course;
import com.example.introduccio_a_les_relacions.repositoris.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Course> llistatCourses() {
        return courseRep.findAll();
    }


    @GetMapping("{id}")
    public Course llistatCoursesId(@PathVariable Long id) {
        if (courseRep.findById(id).isPresent()) {

            return courseRep.findById(id).get();
        } else {
            return null;
        }
    }
}