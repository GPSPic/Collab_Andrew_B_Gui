package com.example.courseservice.controllers;

import com.example.courseservice.models.Course;
import com.example.courseservice.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourse(@PathVariable Long id) {
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/courses")
    public ResponseEntity<Course> postCourse(@RequestBody Course course) {
        courseRepository.save(course);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/courses/{id}")
    public ResponseEntity<Optional> deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<Course> updateCourse(
            @RequestBody Course course,
            @PathVariable Long id){
        Course updatedCourse = courseRepository.findById(id).get();
        updatedCourse.setName(course.getName());
        updatedCourse.setTown(course.getTown());
        updatedCourse.setStarRating(course.getStarRating());

        courseRepository.save(updatedCourse);

        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }
}
