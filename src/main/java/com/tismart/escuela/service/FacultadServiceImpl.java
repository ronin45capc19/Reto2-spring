package com.tismart.escuela.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tismart.escuela.model.Facultad;
import com.tismart.escuela.model.dao.IFacultadDao;
import com.tismart.escuela.response.FacultadResponseRest;

@Service
public class FacultadServiceImpl implements IFacultadService{
	
	private static final Logger log= LoggerFactory.getLogger(FacultadServiceImpl.class);
	
	@Autowired
	private IFacultadDao facultadDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<FacultadResponseRest> buscarFacultad() {
		
		log.info("incio metodo buscarFacultades()");
		
		FacultadResponseRest response= new FacultadResponseRest();
		
		try {
			List<Facultad> facultad=(List<Facultad>) facultadDao.findAll();
			
			response.getFacultadResponse().setFacultad(facultad);
			
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
			
		} catch (Exception e) {
			response.setMetadata("respuesta no ok", "-1", "Respuesta incorrecta");
			log.error("error al consultar facultades: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<FacultadResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<FacultadResponseRest>(response,HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<FacultadResponseRest> buscarPorId(Long id) {
		log.info("Inicio metodo buscarPorId");
		
		FacultadResponseRest response= new FacultadResponseRest();
		List<Facultad> list=new ArrayList<>();
		try {
			Optional<Facultad> facultad=facultadDao.findById(id);
			if(facultad.isPresent()) {
				list.add(facultad.get());
				response.getFacultadResponse().setFacultad(list);
			}else {
				log.error("Error al consultar Facultad");
				response.setMetadata("Respuesta no ok", "-1", "Facultad no encontrada");
				return new ResponseEntity<FacultadResponseRest>(response,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("Error al consultar Facultad");
			response.setMetadata("RESPUESTA NO OK", "-1", "Facultad no encontrada");
			return new ResponseEntity<FacultadResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);				
		}
		return new ResponseEntity<FacultadResponseRest>(response,HttpStatus.OK);
	}
	
	
}
