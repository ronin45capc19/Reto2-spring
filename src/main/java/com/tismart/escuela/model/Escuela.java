package com.tismart.escuela.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="escuela")
public class Escuela {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private Integer CantAlumnos;
	private Double Recurso_Fiscal;
	private Boolean Licenciada;
	private Integer Clasificacion;
	private Date fechaRegistro;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Facultad facultad;
	
	/*
	private Integer facultad_id;
	
	
	public Integer getFacultad_id() {
		return facultad_id;
	}
	public void setFacultad_id(Integer facultad_id) {
		this.facultad_id = facultad_id;
	}*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantAlumnos() {
		return CantAlumnos;
	}
	public void setCantAlumnos(Integer cantAlumnos) {
		CantAlumnos = cantAlumnos;
	}
	public Double getRecurso_Fiscal() {
		return Recurso_Fiscal;
	}
	public void setRecurso_Fiscal(Double recurso_Fiscal) {
		Recurso_Fiscal = recurso_Fiscal;
	}
	public Boolean getLicenciada() {
		return Licenciada;
	}
	public void setLicenciada(Boolean licenciada) {
		Licenciada = licenciada;
	}
	public Integer getClasificacion() {
		return Clasificacion;
	}
	public void setClasificacion(Integer clasificacion) {
		Clasificacion = clasificacion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	public Facultad getFacultad() {
		return facultad;
	}
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	
	@Override
	public String toString() {
		return "Escuela [id=" + id + ", nombre=" + nombre + ", CantAlumnos=" + CantAlumnos + ", Recurso_Fiscal="
				+ Recurso_Fiscal + ", Licenciada=" + Licenciada + ", Clasificacion=" + Clasificacion
				+ ", fechaRegistro=" + fechaRegistro + ", facultad=" + facultad + "]";
	}
	
	
	
	
	
 }
