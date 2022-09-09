package com.Proyectociclo3.Ciclo3.repositorios;

import com.Proyectociclo3.Ciclo3.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {
}
