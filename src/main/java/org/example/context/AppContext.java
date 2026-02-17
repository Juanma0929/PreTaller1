package org.example.context;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Para el ioc container, hacer el contexto como singleton
public class AppContext {

    //Como es una variable estática, se inicializa desde el principio,
    // y se mantiene durante toda la ejecución del programa. Por eso es singleton,
    // porque solo hay una instancia de este contexto durante toda la ejecución del programa.
    /*private static ApplicationContext context
            = new ClassPathXmlApplicationContext("beans.xml");*/

    private static final ApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

    private AppContext() {

    }

    public static ApplicationContext getContext() {
        return context;
    }
}
