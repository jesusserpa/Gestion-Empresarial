package com.Proyectociclo3.Ciclo3.controller;

import com.Proyectociclo3.Ciclo3.entidades.Empresa;
import com.Proyectociclo3.Ciclo3.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Controlador {
    @Autowired
    EmpresaService empresaService;
    @GetMapping ({"/","/VerEmpresas"})
    public String viewEmpresas(Model model){
        List<Empresa> listaEmpresas=empresaService.getAllEmpresas();
        model.addAttribute("emplist",listaEmpresas);
        return "verEmpresas"; //Llamamos al HTML
    }

    @GetMapping("/AgregarEmpresa")
    public String nuevaEmpresa(Model model){
        Empresa emp= new Empresa();
        model.addAttribute("emp",emp);
        return "agregarEmpresa";
    }

    @PostMapping("/GuardarEmpresa")
    public String guardarEmpresa(Empresa emp, RedirectAttributes redirectAttributes){
        if (empresaService.saveOrUpdateEmpresa(emp)==true){
            return "redirect:/VerEmpresas";
        }
        return "redirect:/AgregarEmpresa";
    }
}
