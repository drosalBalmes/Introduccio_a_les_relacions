package com.example.introduccio_a_les_relacions.controllers;

import com.example.introduccio_a_les_relacions.entity.Course;
import com.example.introduccio_a_les_relacions.entity.CourseMaterial;
import com.example.introduccio_a_les_relacions.repositoris.CourseMaterialRepository;
import com.example.introduccio_a_les_relacions.repositoris.CoursesRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> llistatCourseMaterial() {
        List<CourseMaterial> courseMaterials = cmRep.findAll();
        if (courseMaterials.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(courseMaterials);
        }
    }


    @GetMapping("{id}")
    public ResponseEntity<?> llistatCourseMaterialId(@PathVariable Long id) {
        CourseMaterial courseMaterial = cmRep.findById(id).get();
        if (cmRep.findById(id).isPresent()){
            return ResponseEntity.ok(courseMaterial);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}