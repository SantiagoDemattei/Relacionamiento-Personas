package api.services;


import api.dominio.Delegacion;
import api.dominio.Persona;
import api.repositorios.RepoDelegacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.repositorios.RepoPersona;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private final RepoPersona repoPersona;
    @Autowired
    private final RepoDelegacion repoDelegacion;

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
