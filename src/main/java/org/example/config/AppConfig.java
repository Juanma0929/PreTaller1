package org.example.config;

import org.example.repository.CourseRepository;
import org.example.service.CourseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

//Indico que voy a usar una serie de métodos que voy a usar como beans
@Configuration
public class AppConfig {

    //Usando este mecanismo puedo usar objetos hechos por otras personas, como Gson
    @Bean(initMethod = "init")
    //Por defecto, los beans son singleton, pero se puede cambiar a prototype, que es un nuevo objeto cada
    //vez que se pide el bean, o a request, que es un nuevo objeto por cada petición HTTP
    @Scope("singleton")
    public CourseRepository courseRepository(){
        return new CourseRepository();
    }

    //Hace la inyección de dependencias automáticamente,
    //inyecta el courseRepository en el constructor del courseService
    @Bean
    public CourseService courseService(CourseRepository courseRepository){
        return new CourseService(courseRepository);
    }

}















