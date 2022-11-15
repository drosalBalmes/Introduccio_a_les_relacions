package com.example.introduccio_a_les_relacions.repositoris;

import com.example.introduccio_a_les_relacions.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Student,Long> {
    List<Student> findAll();
}
