package api.controllers;

import api.dominio.Persona;
import api.services.UsuarioService;
import api.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void registrarUsuario(@RequestBody Persona persona) throws IOException {
        uService.registrar(persona);
    }

    @PostMapping(path = "/logeousuario")
    public Boolean logearUsuario(@RequestBody Usuario user) {
        return uService.logear(user);
    }

}
