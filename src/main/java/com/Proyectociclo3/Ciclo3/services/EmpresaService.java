package com.Proyectociclo3.Ciclo3.services;

import com.Proyectociclo3.Ciclo3.entidades.Empresa;
import com.Proyectociclo3.Ciclo3.repositorios.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service //Con esto Spring sabra que esta clase es de Servicios

public class EmpresaService {
    @Autowired // Conectamos esta clase con el repositorio de Empresa
    EmpresaRepositorio empresaRepositorio; // Creamos un objeto tipo EmpresaRepository para poder usar los metodos que dicha clase heredo

    //Metodo que retorna la lista de empresas usando metodos heredados del jpaRepository
    public List<Empresa> getAllEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepositorio.findAll().forEach(empresa -> empresaList.add(empresa)); //Recorremos el iterable que regresa el metodo findAll del JPA y la guardamos en la lista
        return empresaList;
    }
    // Metodo que trae un objeto de tipo Empresa cuando cuento con el id de la misma
    public Empresa getEmpresaById(Integer id){
        return empresaRepositorio.findById(id).get();
    }

    //Metodo para guardar o actualizar objetos de tipo Empresa
    public boolean saveOrUpdateEmpresa(Empresa empresa) {

        Empresa emp=empresaRepositorio.save(empresa);
        if (empresaRepositorio.findById(emp.getId())!=null){

            return true;
        }
        return false;
    }

    //Metodo para eliminar una empresa teniendo ID
    public boolean deleteEmpresa(Integer id){
        empresaRepositorio.deleteAllById(Collections.singleton(id));
        if (getEmpresaById(id)!=null){
            return false;
        }
        return true;
    }
}
