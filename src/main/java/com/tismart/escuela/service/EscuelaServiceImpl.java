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

import com.tismart.escuela.model.Escuela;
import com.tismart.escuela.model.dao.IEscuelaDao;
import com.tismart.escuela.response.EscuelaResponseRest;

@Service
public class EscuelaServiceImpl implements IEscuelaService{
	
	private static final Logger log= LoggerFactory.getLogger(EscuelaServiceImpl.class);

	@Autowired
	private IEscuelaDao escuelaDao;
	
	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<EscuelaResponseRest> buscarEscuelas() {
		log.info("inicio metodo buscar escuelas");
		
		EscuelaResponseRest response = new EscuelaResponseRest();
		
		try {
			List<Escuela> escuela=(List<Escuela>) escuelaDao.findAll();
			response.getEscuelaResponse().setEscuela(escuela);
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
			
		} catch (Exception e) {
			response.setMetadata("Respuesta no ok", "-1", "Error al consultar Escuelas");
			log.error("error al consultar escuelas: ",e.getMessage());
			e.getStackTrace();
			return new ResponseEntity<EscuelaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<EscuelaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<EscuelaResponseRest> buscarPorId(Long id) {
		log.info("INICIO METODO BUSCAR POR ID");
		EscuelaResponseRest response= new EscuelaResponseRest();
		List<Escuela> list= new ArrayList<>();
		
		try {
			Optional<Escuela> escuela =escuelaDao.findById(id);
			if(escuela.isPresent()) {
				list.add(escuela.get());
				response.getEscuelaResponse().setEscuela(list);
			}else {
				log.error("Error en consultar escuela");
				response.setMetadata("RESPUESTA NO OK", "-1", "ESCUELA NO ENCONTRADA");
				return new ResponseEntity<EscuelaResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("Error en consultar libro");
			response.setMetadata("RESPUESTA NO OK", "-1", "ERROR AL CONSULTAR ESCUELA");
			return new ResponseEntity<EscuelaResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.setMetadata("RESPUESTA OK", "00", "RESPUESTA EXITOSA");
		return new ResponseEntity<EscuelaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<EscuelaResponseRest> crear(Escuela escuela) {
		log.info("inicio metodo crear escuela");
		EscuelaResponseRest response= new EscuelaResponseRest();
		List<Escuela> list= new ArrayList<>();
		try {
			Escuela escuelaGuardada= escuelaDao.save(escuela);
			if(escuelaGuardada != null) {
				list.add(escuelaGuardada);
				response.getEscuelaResponse().setEscuela(list);
			} else {
				log.error("ERROR EN GRABAR ESCUELA");
				response.setMetadata("RESPUESTA MO OK", "-1", "ESCUELA NO GUARDADA");
				return new ResponseEntity<EscuelaResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("ERROR EN GRABAR ESCUELA");
			response.setMetadata("RESPUESTA NO OK", "-1", "ERROR AL GRABAR ESCUELA");
			return new ResponseEntity<EscuelaResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.setMetadata("RESPUESTA OK", "00", "ESCUELA CREADA");
		return new ResponseEntity<EscuelaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<EscuelaResponseRest> actualizar(Escuela escuela, Long id) {
		log.info("INICIO METODO ACTUALIZAR");
		EscuelaResponseRest response = new EscuelaResponseRest();
		List<Escuela> list= new ArrayList<>();
		
		try {
			Optional<Escuela> escuelaBuscada = escuelaDao.findById(id);
			
			if(escuelaBuscada.isPresent()) {
				escuelaBuscada.get().setNombre(escuela.getNombre());
				escuelaBuscada.get().setCantAlumnos(escuela.getCantAlumnos());
				escuelaBuscada.get().setRecurso_Fiscal(escuela.getRecurso_Fiscal());
				escuelaBuscada.get().setLicenciada(escuela.getLicenciada());
				escuelaBuscada.get().setClasificacion(escuela.getClasificacion());
				escuelaBuscada.get().setFechaRegistro(escuela.getFechaRegistro());
				escuelaBuscada.get().setFacultad(escuela.getFacultad());
				
				Escuela escuelaActualizar= escuelaDao.save(escuelaBuscada.get());
				
				if(escuelaActualizar != null) {
					response.setMetadata("Respuesta ok", "00", "escuela actualizada");
					list.add(escuelaActualizar);
					response.getEscuelaResponse().setEscuela(list);
				}else {
					log.error("ERROR EN ACTUALIZAR ESCUELA");
					response.setMetadata("RESPUESTA NO OK", "-1", "ESCUELA NO ACTUALIZADA");
					return new ResponseEntity<EscuelaResponseRest>(response,HttpStatus.BAD_REQUEST);	
				}
			}else {
				log.error("ERROR EN ACTUALIZAR ESCUELA");
				response.setMetadata("RESPUESTA NO OK", "-1", "ESCUELA NO ACTUALIZADA");
				return new ResponseEntity<EscuelaResponseRest> (response,HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("ERROR EN ACTUALIZAR ESCUELA", e.getMessage());
			e.getStackTrace();
			response.setMetadata("RESPUESTA NO OK", "-1", "ESCUELA NO ACTUALIZADA");
			return new ResponseEntity<EscuelaResponseRest>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EscuelaResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<EscuelaResponseRest> eliminar(Long id) {
		log.info("INICIO METODO ELIMINAR ESCUELA");
		EscuelaResponseRest response= new EscuelaResponseRest();
		try {
			escuelaDao.deleteById(id);
			response.setMetadata("RESPUESTA OK", "00", "ESCUELA ELIMINADA");
		} catch (Exception e) {
			log.error("ERROR EM ELIMINAR ESCUELA", e.getMessage());
			e.getStackTrace();
			response.setMetadata("RESPUESTA NO OK", "-1", "ESCUELA ELIMINADA");
			return new ResponseEntity<EscuelaResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<EscuelaResponseRest>(response, HttpStatus.OK);
	}
}
