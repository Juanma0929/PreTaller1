package org.example.service;

import org.example.entity.Student;
import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public StudentService(CourseRepository courseRepository,
                          StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student student) {
        if(!studentRepository.exists(student)) {
            studentRepository.save(student);
        }
    }

    public List<Student> getCoursesList() {
        return studentRepository.getStudents();
    }
}
