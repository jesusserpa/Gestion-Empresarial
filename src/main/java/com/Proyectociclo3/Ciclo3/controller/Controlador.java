package com.Proyectociclo3.Ciclo3.controller;



import com.Proyectociclo3.Ciclo3.entidades.Empresa;
import com.Proyectociclo3.Ciclo3.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {
    @Autowired
    EmpresaService empresaService;

    @GetMapping("/enterprises")// ver json de todas las empresas
    public List<Empresa> verEmpresas() {
        return empresaService.getAllEmpresas();
    }

    @PostMapping("/enterprises")//Guardar el Json del body como una nueva empresa o registro en nuestra db
    public Empresa guardarEmpresa(@RequestBody Empresa emp){
        return this.empresaService.saveOrUpdateEmpresa(emp);
    }

    @GetMapping(path = "enterprises/{id}")
    public Empresa empresaPorId(@PathVariable("id") Integer id){
        return this.empresaService.getEmpresaById(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarEmpresa(@PathVariable("id") Integer id, @RequestBody Empresa empresa){
        Empresa emp= empresaService.getEmpresaById(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNIT(empresa.getNIT());
        return empresaService.saveOrUpdateEmpresa(emp);
    }

    @DeleteMapping(path = "enterprises/{id}") //Elimina registro de ID
    public String DeleteEmpresa(@PathVariable("id") Integer id){
        boolean respuesta= this.empresaService.deleteEmpresa(id);
        if (respuesta){
            return "Se eliminó la empresa con id" + id;
        }
        else {
            return "No se pudo eliminar la empresa con id" + id;
        }
    }

}



