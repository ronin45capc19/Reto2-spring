package com.tismart.escuela.service;

import org.springframework.http.ResponseEntity;

import com.tismart.escuela.response.FacultadResponseRest;

public interface IFacultadService {
	public ResponseEntity<FacultadResponseRest> buscarFacultad();
	public ResponseEntity<FacultadResponseRest> buscarPorId(Long id);
}
