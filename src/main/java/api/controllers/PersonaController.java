package api.controllers;


import api.dominio.Persona;
import api.services.DelegacionService;
import api.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PersonaController {
    @Autowired
    private final PersonaService personaService;

    public PersonaController(PersonaService pService) {
        this.personaService = pService;
    }

    @PutMapping(path = "/{usuarioSesion}/actualizardatos")
    public void actualizarPersona(@PathVariable String usuarioSesion, @RequestBody Persona p) {
        personaService.actualizarPersona(usuarioSesion, p);
    }


}

