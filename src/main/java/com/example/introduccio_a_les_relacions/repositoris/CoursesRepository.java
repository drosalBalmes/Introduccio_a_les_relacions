package com.example.introduccio_a_les_relacions.repositoris;

import com.example.introduccio_a_les_relacions.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoursesRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();
}
