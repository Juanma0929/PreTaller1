package org.example.repository;

import org.example.entity.Course;

import java.util.ArrayList;

public interface CourseRepository {
    //Guardamos los métodos que se van a implementar en el repositorio de cursos
    //No se guarda el init, ya que para los beans existen distintos tipos de
    //inicialización
    void save(Course course);
    boolean exists(Course course);
    ArrayList<Course> getCourses();

}
