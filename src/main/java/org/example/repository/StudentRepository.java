package org.example.repository;

import org.example.entity.Student;

import java.util.ArrayList;

public class StudentRepository {

    private ArrayList<Student> students = new ArrayList<>();

    //Guardar estudiante en el repositorio
    public void save(Student student) {
        students.add(student);
    }
    //Obtener estudiantes del repositorio
    public ArrayList<Student> getStudents() {
        return students;
    }


}
