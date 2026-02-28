package org.example.service;

import org.example.entity.Course;

import java.util.List;

public interface CourseService {

    void saveCourse(Course course);
    List<Course> getCoursesList();

}
