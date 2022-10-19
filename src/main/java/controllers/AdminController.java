package controllers;

import dominio.Delegacion;
import dominio.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.AdminService;

import java.util.List;

@RestController
@RequestMapping(path = "administrador")
public class AdminController {
    private final AdminService adminService;

    @Autowired
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