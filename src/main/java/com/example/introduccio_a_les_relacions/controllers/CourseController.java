package com.example.introduccio_a_les_relacions.controllers;

import com.example.introduccio_a_les_relacions.entity.Course;
import com.example.introduccio_a_les_relacions.entity.CourseMaterial;
import com.example.introduccio_a_les_relacions.repositoris.CourseMaterialRepository;
import com.example.introduccio_a_les_relacions.repositoris.CoursesRepository;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.FetchType;
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
            System.out.println("Lazy o Eager");
            return ResponseEntity.ok(course);

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public Course eliminar(@PathVariable Long id) {
        if (courseRep.existsById(id)) {
            Course course = courseRep.findById(id).get();
            for (CourseMaterial cm :course.getCourseMaterial()) {
                cm.setCourse(null);
            }
            courseRep.deleteById(id);
            return course;
        }else {
            return null;
        }

    }

}