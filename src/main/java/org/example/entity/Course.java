package org.example.entity;

public class Course {


    private int id;
    //Example: 35

    private String name;

    private String professorName;

    private String schedule;
    //Example: "MI 07:00 08:59, VI 15:00 16:59"


    public Course(int id, String name, String professorName, String schedule) {
        this.id = id;
        this.name = name;
        this.professorName = professorName;
        this.schedule = schedule;
    }

    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    //No es regla de negocio
    //Necesario para comparar objetos y su contenido, no solo su referencia en memoria
    @Override
    public boolean equals(Object obj){
        //Comparamos this con obj
        //Obj es el objeto externo, y this es el objeto interno de la instancia

        //Ver si si obj es intancia de course, si no, entonces no vale ni la pena
        //compararlos
        if(obj instanceof Course) {

            //Si obj es instancia de course, entonces lo casteamos a
            // course para poder comparar sus atributos
            Course other = (Course) obj;
            //Si el id es igual, entonces los cursos son iguales
            return
                    other.getId() == this.getId();
        }else return false;
    }
}
