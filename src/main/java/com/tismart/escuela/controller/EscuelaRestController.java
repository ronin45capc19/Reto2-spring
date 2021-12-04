package com.tismart.escuela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tismart.escuela.model.Escuela;
import com.tismart.escuela.response.EscuelaResponseRest;
import com.tismart.escuela.service.IEscuelaService;

@CrossOrigin(origins ={"http://localhost:4200"})
@RestController
@RequestMapping("/v1")
public class EscuelaRestController {
	
	@Autowired
	private IEscuelaService service;
	/*
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		ResponseEntity<EscuelaResponseRest> response= service.buscarEscuelas();
		model.addAttribute("escuelas",response);
		return "escuelas/listEscuelas";
	}
	*/
	@GetMapping("/escuelas")
	public ResponseEntity<EscuelaResponseRest> consultaEscuelas(){
		ResponseEntity<EscuelaResponseRest> response= service.buscarEscuelas();
		return response;
	}
	
	@GetMapping("/escuelas/{id}")
	public ResponseEntity<EscuelaResponseRest> consultaPorId(@PathVariable Long id){
		ResponseEntity<EscuelaResponseRest> response=service.buscarPorId(id);
		return response;
	}
	
	@PostMapping("/escuelas")
	public ResponseEntity<EscuelaResponseRest> crear(@RequestBody Escuela escuela){
		ResponseEntity<EscuelaResponseRest> response=service.crear(escuela);
		return response;
	}
	
	@PutMapping("/escuelas/{id}")
	public ResponseEntity<EscuelaResponseRest> actualizar (@RequestBody Escuela escuela,@PathVariable Long id){
		ResponseEntity<EscuelaResponseRest> response=service.actualizar(escuela, id);
		return response;
	}
	
	@DeleteMapping("/escuelas/{id}")
	public ResponseEntity<EscuelaResponseRest> eliminar (@PathVariable Long id){
		ResponseEntity<EscuelaResponseRest> response= service.eliminar(id);
		return response;
	}
	

}
