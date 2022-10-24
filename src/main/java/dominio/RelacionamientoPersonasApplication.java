package dominio;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repositorios.RepoPersona;
import repositorios.RepoUsuario;
import services.UsuarioService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RelacionamientoPersonasApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(RelacionamientoPersonasApplication.class, args);
	}
}
