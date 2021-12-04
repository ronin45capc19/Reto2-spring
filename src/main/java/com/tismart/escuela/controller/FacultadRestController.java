package com.tismart.escuela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tismart.escuela.response.FacultadResponseRest;
import com.tismart.escuela.service.IFacultadService;

@RestController
@RequestMapping("/facultad")
public class FacultadRestController {
	@Autowired
	private IFacultadService service;
	
	@GetMapping("/buscar")
	public ResponseEntity<FacultadResponseRest> consultaFacultad(){
		
		ResponseEntity<FacultadResponseRest> response= service.buscarFacultad();
		return response;
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<FacultadResponseRest> consultarPorId(@PathVariable Long id){
		ResponseEntity<FacultadResponseRest> response= service.buscarPorId(id);
		return response;
	}
}
