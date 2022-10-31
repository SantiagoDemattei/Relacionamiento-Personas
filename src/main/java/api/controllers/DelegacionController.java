package api.controllers;

import api.dominio.Delegacion;
import api.dominio.Persona;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import api.services.DelegacionService;

import java.util.List;

@RestController
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

    @GetMapping(path = "/{sesionUsuario}/delegacionesenespera")
    public List<Delegacion> obtenerDelegacionesEnEspera(@PathVariable String sesionUsuario) {
        return delegacionService.obtenerDelegacionesEnEspera(sesionUsuario);
    }

    @PutMapping(path = "/{sesionUsuario}/aceptardelegacion/{delegationId}")
    public ResponseEntity aceptarDelegacion(@PathVariable String sesionUsuario, @PathVariable Long delegationId) {
        SesionManager sesionManager = SesionManager.get();
        if (sesionManager.obtenerAtributos(sesionUsuario) != null) {
            if (delegacionService.aceptarDelegacion(delegationId)) {
                return ResponseEntity.ok().body("Delegacion aceptada");
            } else {
                return ResponseEntity.badRequest().body("Error al aceptar delegacion");
            }
        } else {
            return ResponseEntity.badRequest().body("Sesion invalida");
        }
    }

    @DeleteMapping(path = "/{sesionUsuario}/rechazardelegacion/{delegationId}")
    public ResponseEntity rechazarDelegacion(@PathVariable String sesionUsuario, @PathVariable Long delegationId) {
        SesionManager sesionManager = SesionManager.get();
        if (sesionManager.obtenerAtributos(sesionUsuario) != null) {
            if (delegacionService.rechazarDelegacion(delegationId)) {
                return ResponseEntity.ok().body("Delegacion rechazada");
            } else {
                return ResponseEntity.badRequest().body("Error al rechazar delegacion");
            }
        } else {
            return ResponseEntity.badRequest().body("Sesion invalida");
        }
    }

    @PostMapping(path = "/{sesionUsuario}/autorizacion")
    public ResponseEntity realizarDelegacion(@PathVariable("sesionUsuario") String sesionUsuario, @RequestBody String dniDelegado) {
        JSONObject jsonObj = new JSONObject(dniDelegado); // tuve que pasar a json el string porque llegaba {"dniDelegado" : "xxxxxxxx"}
        String dni = (String) jsonObj.get("dniDelegado"); // aca obtengo el valor asociado a la clave "dniDelegado"
        delegacionService.realizarDelegacion(sesionUsuario, dni);
        return ResponseEntity.ok().body("Delegacion realizada");
    }


}
