package services;


import dominio.Delegacion;
import dominio.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositorios.RepoDelegacion;
import repositorios.RepoPersona;

import java.util.List;

@Service
public class AdminService {

    private final RepoPersona repoPersona;
    private final RepoDelegacion repoDelegacion;

    @Autowired
    public AdminService(RepoPersona repoPersonas, RepoDelegacion repoDelegaciones) {
        this.repoPersona = repoPersonas;
        this.repoDelegacion = repoDelegaciones;
    }

    public List<Persona> obtenerPersonas() {
        return repoPersona.findAll();
    }

    public List<Delegacion> obtenerDelegaciones() {
        return repoDelegacion.findAll();
    }
}
