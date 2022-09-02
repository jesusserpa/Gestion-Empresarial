package com.Proyectociclo3.Ciclo3;

import com.Proyectociclo3.Ciclo3.entidades.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication (exclude ={SecurityAutoConfiguration.class})
public class Ciclo3Application {

	@GetMapping("/hello")
	public String hello(){
		return "Ciclo 3";
	}

	@GetMapping("/test")
	public String test(){
		Empresa emp = new Empresa("Stark Motorcycles","Calle 21 # 05","3154852355","445455543-2");
		return emp.getNombre();

	}

	public static void main(String [] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

}
