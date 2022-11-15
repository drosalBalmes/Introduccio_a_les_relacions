package com.example.introduccio_a_les_relacions.entity;

import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    @ToStringExclude
    private List<CourseMaterial> courseMaterial;

    @ManyToMany(mappedBy = "courses")
    private List<Student> student = new ArrayList<>();

    public Course() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<CourseMaterial> getCourseMaterial() {
        return courseMaterial;
    }

    public void setCourseMaterial(List<CourseMaterial> courseMaterial) {
        this.courseMaterial = courseMaterial;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
