package controllers;


import dominio.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.PersonaService;

@RestController
@RequestMapping(path = "person")
public class PersonaController {
    private final PersonaService personaService;

    @Autowired
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

