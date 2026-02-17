package org.example.service;

import org.example.entity.Course;
import org.example.repository.CourseRepository;

//Logica de negocio
public class CourseService {

    private CourseRepository courseRepository;

    //Necesita usar courseRepository para poder operar

    //Inyectar la dependencia de courseRepository en el constructor
    //En el caso de que también dependa de studentRepository,
    // entonces se inyecta también en el constructor como parameto del constructor
    public CourseService(CourseRepository course) {
        this.courseRepository = courseRepository;
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

}
