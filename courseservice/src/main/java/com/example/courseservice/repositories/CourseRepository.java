package com.example.courseservice.repositories;

import com.example.courseservice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCourseByStarRating(double rating);
}
