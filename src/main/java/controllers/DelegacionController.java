package controllers;

import dominio.Delegacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.DelegacionService;

@RestController
@RequestMapping(path = "delegation")
public class DelegacionController {
    private final DelegacionService delegacionService;

    @Autowired
    public DelegacionController(DelegacionService delegationService) {
        this.delegacionService = delegationService;
    }

    @GetMapping(path = "{delegationId}")
    public Delegacion getDelegationById(@PathVariable("delegationId") Long delegationId) {
        return delegacionService.getDelegacionByDelegacion_id(delegationId);
    }

    @PostMapping(path = "authorization")
    public void delegationAuthorization(@RequestParam Long dniDelegado, @RequestParam Long dniDelegador) {
        delegacionService.delegationAuthorization(dniDelegado, dniDelegador);
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
