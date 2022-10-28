package controllers;

import dominio.Persona;
import dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import services.UsuarioService;

import java.io.IOException;

@RestController
@CrossOrigin
public class UsuarioController {

    private final UsuarioService uService;

    @Autowired
    public UsuarioController(UsuarioService uService) {
        this.uService = uService;
    }

    @GetMapping(path = "{userId}")
    public Usuario getUserById(@PathVariable("userId") Long uId) {
        return uService.obtenerUsuario(uId);
    }

    @PostMapping(path = "/registrousuario")
    public void registrarUsuario(@RequestBody Persona persona) throws IOException {
        uService.registrar(persona);
    }

    @PostMapping(path = "login")
    public Boolean logearUsuario(@RequestBody Usuario user) {
        return uService.logear(user);
    }

}
