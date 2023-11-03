package com.mycompany.modelo.cita;

import java.time.LocalDateTime;

import com.mycompany.modelo.duenio.Duenio;
import com.mycompany.modelo.mascota.Mascota;

public class Cita {

// ATRIBUTOS 
	private Integer idCita;
	private Integer idMascota;
	private LocalDateTime citaAgendada;
	private Boolean citaActiva;
	
	private Mascota mascota;
	private Duenio duenio;
	
// CONSTRUCTORES
	public Cita(Integer idMascota, LocalDateTime citaAgendada) {
		this.idMascota = idMascota;
		this.citaAgendada = citaAgendada;
		this.citaActiva = true;
	}
	
	public Cita(Integer idCita, Integer idMascota, LocalDateTime citaAgendada) {
		this(idMascota, citaAgendada);
		this.idCita = idCita;
		this.citaActiva = true;
	}

// MÉTODOS
	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public Integer getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Integer idMascota) {
		this.idMascota = idMascota;
	}

	public LocalDateTime getCitaAgendada() {
		return citaAgendada;
	}

	public void setCitaAgendada(LocalDateTime citaAgendada) {
		this.citaAgendada = citaAgendada;
	}

	public Boolean getCitaActiva() {
		return citaActiva;
	}

	public void setCitaActiva(Boolean citaActiva) {
		this.citaActiva = citaActiva;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Duenio getDuenio() {
		return duenio;
	}

	public void setDuenio(Duenio duenio) {
		this.duenio = duenio;
	}
	
	
	
}
