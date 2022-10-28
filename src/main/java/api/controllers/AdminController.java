package api.controllers;

import api.dominio.Delegacion;
import api.dominio.Persona;
import api.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "administrador")
public class AdminController {
    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(path = "person-list")
    public List<Persona> obtenerPersonas() {
        return adminService.obtenerPersonas();
    }

    @GetMapping(path = "delegation-list")
    public List<Delegacion> obtenerDelegaciones() {
        return adminService.obtenerDelegaciones();
    }
}