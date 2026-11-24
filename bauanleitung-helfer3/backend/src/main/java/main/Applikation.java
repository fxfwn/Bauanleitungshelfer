package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Applikation {
    public static void main(String[] args) {
        SpringApplication.run(Applikation.class, args);
    }
    /*
    * add these to environment variables
    * SPRING_DATASOURCE_URL=jdbc:sqlite:backend/database/Bauanleitung.db;
    * SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.sqlite.JDBC;
    * spring.jpa.open-in-view=false;
    * spring.freemarker.check-template-location=false
    * */
}
