package com.mycompany.modelo.duenio;

import java.util.List;

import com.mycompany.modelo.mascota.Mascota;

public class Duenio {
	
 // ATRIBUTOS
	private Integer idDuenio;
	private String nombreDuenio;
	private String telefono;
	private String direccion;
	private Boolean activo;
	private List<Mascota> mascota;
	
 // CONSTRUCTORES
	public Duenio(Integer idDuenio, String nombreDuenio, String telefono) {
		this.idDuenio = idDuenio;
		this.nombreDuenio = nombreDuenio;
		this.telefono = telefono;
	}
	
	public Duenio(String nombreDuenio, String telefono, String direccion) {
		this.nombreDuenio = nombreDuenio;
		this.telefono = telefono;
		this.direccion = direccion;
		this.activo = true;
	}
	
	public Duenio(Integer idDuenio, String nombreDuenio, String telefono, String direccion) {
		this(nombreDuenio, telefono, direccion);
		this.idDuenio = idDuenio;		
		this.activo = true;
	}

 // MÉTODOS	
	public Integer getIdDuenio() {
		return idDuenio;
	}

	public void setIdDuenio(Integer idDuenio) {
		this.idDuenio = idDuenio;
	}
	
	public String getNombreDuenio() {
		return nombreDuenio;
	}

	public void setNombreDuenio(String nombreDuenio) {
		this.nombreDuenio = nombreDuenio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void desactivarDuenio() {
		this.activo = false;
	}

	public List<Mascota> getMascota() {
		return mascota;
	}

	public void setMascota(List<Mascota> mascota) {
		this.mascota = mascota;
	}
	
	

	
}
