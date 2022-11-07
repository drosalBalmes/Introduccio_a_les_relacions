package com.example.introduccio_a_les_relacions.controllers;

import com.example.introduccio_a_les_relacions.entity.Course;
import com.example.introduccio_a_les_relacions.entity.CourseMaterial;
import com.example.introduccio_a_les_relacions.repositoris.CourseMaterialRepository;
import com.example.introduccio_a_les_relacions.repositoris.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("course_material")

public class CourseMaterialController {
    @Autowired //per instanciar automaticament cuan sigui necesari
    CourseMaterialRepository cmRep;

    @GetMapping("")
    public List<CourseMaterial> llistatCourseMaterial() {
        return cmRep.findAll();
    }


    @GetMapping("{id}")
    public CourseMaterial llistatCourseMaterialId(@PathVariable Long id) {
        if (cmRep.findById(id).isPresent()) {

            return cmRep.findById(id).get();
        } else {
            return null;
        }
    }
}