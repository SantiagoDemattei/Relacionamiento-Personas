package api.services;

import api.dominio.Delegacion;
import api.dominio.EstadoDelegacion;
import api.dominio.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.repositorios.RepoDelegacion;
import api.repositorios.RepoPersona;

import javax.transaction.Transactional;

@Service
public class DelegacionService {
    @Autowired
    private final RepoDelegacion repoDelegacion;
    @Autowired
    private final RepoPersona repoPersonas;

    public DelegacionService(RepoDelegacion delegationRepository, RepoPersona personRepository) {
        this.repoDelegacion = delegationRepository;
        this.repoPersonas = personRepository;
    }

    public Delegacion getDelegacionByDelegacion_id(Long idDelegation) {
        this.validarIdDelegacion(idDelegation);
        return repoDelegacion.findByDelegacionId(idDelegation);
    }

    @Transactional
    public void delegationAuthorization(Long dniDelegado, Long dniDelegador) {
        Persona delegado = repoPersonas.findPersonaByDni(dniDelegado);
        Persona delegador = repoPersonas.findPersonaByDni(dniDelegador);

        Delegacion delegacion = new Delegacion(delegado, delegador) ;
        delegado.addDelegadoDelegacion(delegacion);
        delegador.addDelegadorDelegacion(delegacion);

        repoDelegacion.save(delegacion);
    }


    @Transactional
    public void delegationAcceptance(Long delegacionId, Boolean rtaDelegacion) {
        if(rtaDelegacion)
            this.getDelegacionByDelegacion_id(delegacionId).setEstado(EstadoDelegacion.ACEPTADA);
        else
            this.getDelegacionByDelegacion_id(delegacionId).setEstado(EstadoDelegacion.RECHAZADA);
    }

    public void delegationAuthorizationRevoke(Long idDelegacion) {
        repoDelegacion.deleteByDelegacionId(idDelegacion);
    }

    private void validarIdDelegacion(Long id) {
        if(id <= 0)
            System.out.println("ID " + id + " invalido");

        if(!repoDelegacion.existsById(id))
            System.out.println("No existe una delegacion con ID " + id);

    }
}