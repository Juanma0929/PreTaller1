package org.example.service;

import org.example.entity.Student;
import org.example.repository.impl.CourseRepositoryImpl;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private CourseRepositoryImpl courseRepositoryImpl;
    private StudentRepository studentRepository;

    public StudentService(CourseRepositoryImpl courseRepositoryImpl,
                          StudentRepository studentRepository) {
        this.courseRepositoryImpl = courseRepositoryImpl;
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
