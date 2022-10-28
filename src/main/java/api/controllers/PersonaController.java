package api.controllers;


import api.dominio.Persona;
import api.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "person")
public class PersonaController {
    @Autowired
    private final PersonaService personaService;

    public PersonaController(PersonaService pService) {
        this.personaService = pService;
    }

    @GetMapping(path = "{personId}")
    public Persona obtenerPersonaPorId(@PathVariable("personId") Long pId) {
        return personaService.obtenerPersona(pId);
    }

    @PutMapping(path = "update")
    public void actualizarPersona(@RequestBody Persona p) {
        personaService.actualizarPersona(p);
    }
}

