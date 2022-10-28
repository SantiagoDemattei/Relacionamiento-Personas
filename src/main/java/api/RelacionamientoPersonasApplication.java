package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;


@SpringBootApplication
public class RelacionamientoPersonasApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(RelacionamientoPersonasApplication.class, args);
    }

}