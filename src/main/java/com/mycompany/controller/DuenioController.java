package com.mycompany.controller;

import com.mycompany.dao.DuenioDao;
import com.mycompany.factory.ConnectionFactory;
import com.mycompany.modelo.duenio.Duenio;

public class DuenioController {
	
	private DuenioDao duenioDao;
	
	public DuenioController() {
		this.duenioDao = new DuenioDao(new ConnectionFactory().recuperaConexion());
	}

	public void guardar(Duenio duenio) {
		duenioDao.guardar(duenio);
	}

	public Duenio buscarDuenioPorNombreYTelefono(String nombreDuenio, String telefono) {
		return duenioDao.buscarPorNombreYTelefono(nombreDuenio, telefono);	
	}

	public void actualizarDuenioPorId(Integer idDuenio, String nombreDuenio, String telefono, String direccion) {
		duenioDao.actualizarPorId(idDuenio, nombreDuenio, telefono, direccion);		
	}

	public void eliminarDuenioPorId(Integer idDuenio) {
		duenioDao.eliminarPorId(idDuenio);
	}

}
