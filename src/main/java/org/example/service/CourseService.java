package org.example.service;

import org.example.entity.Course;
import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//Logica de negocio
@Service
public class CourseService {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    //Necesita usar courseRepository para poder operar

    //Inyectar la dependencia de courseRepository en el constructor
    //En el caso de que también dependa de studentRepository,
    // entonces se inyecta también en el constructor como parametro del constructor
    public CourseService(CourseRepository course, StudentRepository student) {

        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    //CRUD
    //Aqui lleva
    public void saveCourse(Course course) {

        //Si quiero mantener la integridad de la base de datos, entonces
        //pregunto si el curso ya existe en el repositorio, si existe no lo guardo,
        //si no existe lo guardo
        if(!courseRepository.exists(course)) {
            courseRepository.save(course);
        }
    }

    public List<Course> getCoursesList() {
        return courseRepository.getCourses();
    }

}
