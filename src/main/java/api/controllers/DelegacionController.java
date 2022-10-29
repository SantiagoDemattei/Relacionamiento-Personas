package api.controllers;

import api.dominio.Delegacion;
import api.dominio.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.services.DelegacionService;

import java.util.List;

@RestController
@RequestMapping(path = "delegation")
public class DelegacionController {
    @Autowired
    private final DelegacionService delegacionService;

    public DelegacionController(DelegacionService delegationService) {
        this.delegacionService = delegationService;
    }

    @GetMapping(path = "{delegationId}")
    public Delegacion getDelegationById(@PathVariable("delegationId") Long delegationId) {
        return delegacionService.getDelegacionByDelegacion_id(delegationId);
    }

    @PostMapping(path = "/{sesionUsuario}/autorizacion")
    public ResponseEntity realizarDelegacion(@PathVariable("sesionUsuario") String sesionUsuario, @RequestBody String dniDelegado) {
        delegacionService.realizarDelegacion(sesionUsuario, dniDelegado);
        return ResponseEntity.ok().body("Delegacion realizada");
    }

    @PutMapping(path = "acceptance")
    public void delegationAcceptance(@RequestParam Long idDelegacion, @RequestParam Boolean aceptacionDelegacion) {
        delegacionService.delegationAcceptance(idDelegacion, aceptacionDelegacion);
    }

    @DeleteMapping(path = "revoke-authorization/{delegationId}") // Item: 6
    public void delegationAuthorizationRevoke(@PathVariable Long idDelegacion) {
        delegacionService.delegationAuthorizationRevoke(idDelegacion);
    }
}
