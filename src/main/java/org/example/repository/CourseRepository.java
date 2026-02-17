package org.example.repository;

import org.example.entity.Course;

import java.util.ArrayList;

//Cualquier operación de CRUD (Create, Read, Update, Delete)
// se realiza en el repositorio
public class CourseRepository {

    private ArrayList<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
        System.out.println("Courses: "+courses.size());
    }
    public ArrayList<Course> getCourses() {
        return courses;
    }

    //Funciona con el equals de course
    public boolean exists(Course course) {
        return courses.contains(course);
    }

    //Crear elementos de prueba en el repositorio
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
