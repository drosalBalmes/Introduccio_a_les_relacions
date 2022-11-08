package com.example.introduccio_a_les_relacions.repositoris;

import com.example.introduccio_a_les_relacions.entity.Course;
import com.example.introduccio_a_les_relacions.entity.CourseMaterial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseMaterialRepository extends CrudRepository<CourseMaterial,Long> {
    List<CourseMaterial> findAll();
}
