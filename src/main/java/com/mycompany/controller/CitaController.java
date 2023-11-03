package com.mycompany.controller;

import java.time.LocalDateTime;

import com.mycompany.dao.CitaDao;
import com.mycompany.factory.ConnectionFactory;
import com.mycompany.modelo.cita.Cita;

public class CitaController {

// ATRIBUTOS	
	private CitaDao citaDao;
	
// CONSTRUCTORES
	public CitaController() {
		citaDao = new CitaDao(new ConnectionFactory().recuperaConexion());
	}

// MÉTODOS
	public Cita buscarIdDuenioYNombreMascota(Integer idDuenio, String nombreMascota) {
		return citaDao.buscarInnerJoinIdDYNombreMascota(idDuenio, nombreMascota);
	}

	public Cita buscarPorIds(Integer idDuenio, Integer idMascota) {
		return citaDao.buscarInnerJoinIds(idDuenio, idMascota);
	}

	public Cita buscarPorNombreDuenioYIdMascota(String nombreDuenio, Integer idMascota) {
		return citaDao.buscarInnerJoinNombreDuenioYIdMascota(nombreDuenio, idMascota);
	}

	public Cita buscarPorIdCita(Integer idCita) {
		return citaDao.buscarIdCita(idCita);
	}

	public void agendarCita(Cita cita) {
		citaDao.agendarCita(cita);
	}

	public Cita buscarCitaActivaPorFechaYIdMasc(LocalDateTime fechaYHoraLD, Integer idMascota) {
		return citaDao.buscarCitaActivaPorFechaYIdMascota(fechaYHoraLD, idMascota);
	}

	public void modificarCita(Integer idCita, LocalDateTime fechaYHora){
		citaDao.modificarCita(idCita, fechaYHora);
	}

	public void eliminarCita(Integer idCita){
		citaDao.eliminarCita(idCita);
	}	
}
