package org.example.repository.impl;

import jakarta.annotation.PostConstruct;
import org.example.entity.Course;
import org.example.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

//Cualquier operación de CRUD (Create, Read, Update, Delete)
// se realiza en el repositorio
@Repository
public class CourseRepositoryImpl implements CourseRepository {

    private ArrayList<Course> courses = new ArrayList<>();

    public CourseRepositoryImpl() {}

    @Override
    public void save(Course course) {
        courses.add(course);
        System.out.println("Courses: "+courses.size());
    }

    @Override
    public ArrayList<Course> getCourses() {
        return courses;
    }

    //Funciona con el equals de course
    @Override
    public boolean exists(Course course) {
        return courses.contains(course);
    }

    //Crear elementos de prueba en el repositorio
    @PostConstruct
    private void init(){
        System.out.println("Initializing courses");
        courses.add(new Course(1,
                "Computación II",
                "Kevin",
                "Miercoles"));

        courses.add(new Course(2,
                "Estructura de Datos",
                "Kevin 2",
                "Lunes"));
    }
}
