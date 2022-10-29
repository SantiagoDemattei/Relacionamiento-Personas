package api.controllers;

import api.dominio.Persona;
import api.services.UsuarioService;
import api.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
public class UsuarioController {

    @Autowired
    private final UsuarioService uService;

    public UsuarioController(UsuarioService uService) {
        this.uService = uService;
    }

    @GetMapping(path = "{userId}")
    public Usuario getUserById(@PathVariable("userId") Long uId) {
        return uService.obtenerUsuario(uId);
    }

    @PostMapping(path = "/registrousuario")
    public ResponseEntity registrarUsuario(@RequestBody Persona persona) throws IOException {
        if(uService.registrar(persona)){
            return ResponseEntity.ok().body("Usuario registrado con exito");
        } else {
            return ResponseEntity.badRequest().body("Error al registrar usuario");
        }
    }

    @PostMapping(path = "/logeousuario")
    public ResponseEntity logearUsuario(@RequestBody Usuario user) {
        if (uService.logear(user)) {
            SesionManager sesionManager = SesionManager.get();
            String idSesion = sesionManager.crearSesion("usuario", user);
            return ResponseEntity.ok().body(idSesion);
        }
        return ResponseEntity.badRequest().body("Usuario o contraseña incorrectos");
    }
}
