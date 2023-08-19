package com.microservicio.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservicio.app.model.Curso;

import jakarta.annotation.PostConstruct;

@RestController
public class mainController {
	final String key="key";
	final String test="/simpleGetMapping";
	final String pathVariable="/pathvariable/{"+key+"}";
	final String requestParam="/requestparam";
	final String cursoController="/curso";
	final String cursosController="/cursos";
	final String filtroDeCursos="/cursos/{"+key+"}";

	private List cursos;
	@PostConstruct //Se dispara despues del constructor, sirve para generar instancias al iniciar el servidor
	public void init() {
		cursos = new ArrayList();
		cursos.add(new Curso("Spring",1,"Tarde"));
		cursos.add(new Curso("React",2,"Noche"));
		cursos.add(new Curso("Angular",3,"Tarde"));
	}
	@GetMapping(value=test, produces = MediaType.TEXT_PLAIN_VALUE)
	public String holaMundoSpring() {
		return "Hola Mundo en spring";
	}
	@GetMapping(value=pathVariable, produces = MediaType.TEXT_PLAIN_VALUE)
	public String pathVariable(@PathVariable(key) String value) {
		return "Hola "+ value;
	}
	@GetMapping(value=requestParam, produces = MediaType.TEXT_PLAIN_VALUE)
	public String requestParam(@RequestParam("clave") String clave, @RequestParam("valor") String valor) {
		return "Clave: "+ clave + " Valor: "+ valor;
	}
	@GetMapping(value=cursoController, produces = MediaType.APPLICATION_JSON_VALUE)
	public Curso getCurso() {
		return new Curso("Java",10,"Capacitacion");
	}
	@GetMapping(value=cursosController, produces = MediaType.APPLICATION_XML_VALUE)
	public List getCursos() {
		return cursos;
	}
	@GetMapping(value=filtroDeCursos, produces = MediaType.APPLICATION_JSON_VALUE)
	public List getCursosPorNombre(@PathVariable(key) String textoBuscado) {
		List aux = new ArrayList();
		for (Object c: cursos) {
			if (((Curso)c).getNombre().contains(textoBuscado)){
				aux.add(c);
			}
		}
		return aux;
	}
}
