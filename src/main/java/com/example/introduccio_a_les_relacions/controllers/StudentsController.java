package com.example.introduccio_a_les_relacions.controllers;

import com.example.introduccio_a_les_relacions.entity.Student;
import com.example.introduccio_a_les_relacions.repositoris.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentsController {
    @Autowired
    StudentsRepository studentsRep;

    @GetMapping("")
    public ResponseEntity<?> llistatStudents(){
        List<Student> students = studentsRep.findAll();
        if (students.isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(students);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> studentsId(@PathVariable Long id) {
        Student student = studentsRep.findById(id).get();

        if (studentsRep.findById(id).isPresent()){
            return ResponseEntity.ok(student);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
