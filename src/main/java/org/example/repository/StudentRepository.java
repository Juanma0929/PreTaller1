package org.example.repository;

import jakarta.annotation.PostConstruct;
import org.example.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class StudentRepository {

    private ArrayList<Student> students = new ArrayList<>();

    //Guardar estudiante en el repositorio
    public void save(Student student) {

        students.add(student);
        System.out.println("Students: "+students.size());
    }
    //Obtener estudiantes del repositorio
    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean exists(Student student) {
        return students.contains(student);
    }

    @PostConstruct
    private void init(){
        System.out.println("Initializing students");
        students.add(new Student());
    }
}
