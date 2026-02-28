package org.example.service.impl;

import org.example.entity.Course;
import org.example.repository.CourseRepository;
import org.example.repository.StudentRepository;
import org.example.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

//Logica de negocio
//Esto genera un bean llamado courseService
//Puedo llamarlo otra cosa @Service("2")
@Service
public class CourseServiceImpl implements CourseService {

    //Esta capa no conoce la implementacion de courseRepository,
    // solo conoce la interfaz de courseRepository
    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    //Necesita usar courseRepository para poder operar

    //Inyectar la dependencia de courseRepository en el constructor
    //En el caso de que también dependa de studentRepository,
    // entonces se inyecta también en el constructor como parametro del constructor
    public CourseServiceImpl(/*@Qualifier("courseRepositoryImp") si tengo más implementations*/
            CourseRepository course, StudentRepository student) {

        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    //CRUD
    //Aquí lleva
    @Override
    public void saveCourse(Course course) {

        //Si quiero mantener la integridad de la base de datos, entonces
        //pregunto si el curso ya existe en el repositorio, si existe no lo guardo,
        //si no existe lo guardo
        if(!courseRepository.exists(course)) {
            courseRepository.save(course);
        }
    }

    @Override
    public List<Course> getCoursesList() {
        return courseRepository.getCourses();
    }

}
