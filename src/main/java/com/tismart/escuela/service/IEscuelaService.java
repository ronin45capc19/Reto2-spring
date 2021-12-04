package com.tismart.escuela.service;

import org.springframework.http.ResponseEntity;

import com.tismart.escuela.model.Escuela;
import com.tismart.escuela.response.EscuelaResponseRest;

public interface IEscuelaService {
	public ResponseEntity<EscuelaResponseRest> buscarEscuelas();
	public ResponseEntity<EscuelaResponseRest> buscarPorId(Long id);
	public ResponseEntity<EscuelaResponseRest> crear(Escuela escuela);
	public ResponseEntity<EscuelaResponseRest>actualizar(Escuela escuela, Long id);
	public ResponseEntity<EscuelaResponseRest> eliminar (Long id);
}
