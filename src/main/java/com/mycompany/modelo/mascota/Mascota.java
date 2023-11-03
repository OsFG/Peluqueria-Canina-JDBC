package com.mycompany.modelo.mascota;

import java.util.List;

import com.mycompany.modelo.cita.Cita;
import com.mycompany.modelo.duenio.Duenio;

public class Mascota {
	
 // ATRIBUTOS
	private Integer idMascota;
	private String nombreMascota;
	private String raza;
	private String color;
	private String alergico;
	private String atencionEspecial;
	private String observaciones;
	private Integer idDuenio;
	private List<Cita> registroCitas;

 //	CONSTRUCTORES
	public Mascota(Integer idMascota, String nombreMascota, String raza) {
		this.idMascota = idMascota;
		this.nombreMascota = nombreMascota;
	 	this.raza = raza;
	}
	
	public Mascota(Integer idMascota, String nombreMascota, String raza, Integer idDuenio) {
		this(idMascota, nombreMascota, raza);
	 	this.idDuenio = idDuenio;
	 }
	
	public Mascota(String nombreMascota, String color, String raza, String alergico, String atencionEspecial, String observaciones, Integer idDuenio) {
		this.nombreMascota = nombreMascota;
		this.color = color;
		this.raza = raza;
		this.alergico = alergico; 
		this.atencionEspecial = atencionEspecial;
		this.observaciones = observaciones;
		this.idDuenio = idDuenio;
	}
	
	public Mascota(Integer idMascota, String nombreMascota, String color, String raza, String alergico, String atencionEspecial, String observaciones, Integer idDuenio) {
		this(nombreMascota, color, raza, alergico, atencionEspecial, observaciones, idDuenio);
		this.idMascota = idMascota;
		
	}
	
 public Mascota(Integer idMascota, String raza, String alergico, String atencionEspecial, String observaciones) {
	 	this.idMascota = idMascota;
	 	this.raza = raza;
		this.alergico = alergico; 
		this.atencionEspecial = atencionEspecial;
		this.observaciones = observaciones;
	}
 

// MÉTODOS
	public void setId(Integer idMascota) {
		this.idMascota = idMascota;
	}
	public Integer getIdMascota() {
		return idMascota;
	}
	
	public String getNombreMascota() {
		return nombreMascota;
	}

	
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAlergico() {
		return alergico;
	}

	public void setAlergico(String alergico) {
		this.alergico = alergico;
	}

	public String getAtencionEspecial() {
		return atencionEspecial;
	}

	public void setAtencionEspecial(String atencionEspecial) {
		this.atencionEspecial = atencionEspecial;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public void setIdDuenio(Integer idDuenio) {
		this.idDuenio = idDuenio;
	}

	public int getIdDuenio() {
		return idDuenio;
	}
	


}
