package com.mycompany.controller;

import com.mycompany.dao.MascotaDao;
import com.mycompany.factory.ConnectionFactory;
import com.mycompany.modelo.mascota.Mascota;

public class MascotaController {
	
	private MascotaDao mascotaDao;
	
	public MascotaController(){
		this.mascotaDao = new MascotaDao(new ConnectionFactory().recuperaConexion());
	}
	
	public void guardar(Mascota mascota) {
		mascotaDao.guardar(mascota);
	}

	public Mascota buscarMascotaPorNombreMascotaIdDuenio(String nombre, Integer idDuenio) {
		return mascotaDao.buscarMascotaPorNombreMascotaYIdDuenio(nombre, idDuenio);
	}

	public Mascota buscarMascotaPorIds(Integer idDuenio, Integer idMascota) {
		Integer idMas = idMascota;
		return mascotaDao.buscarMascotaPorIds(idDuenio, idMas);
	}

	public Mascota buscarMascotaPorIdDYNombreM(Integer idDuenio, String nombreMascota) {
		return mascotaDao.buscarMascotaPorIdDYNombreM(idDuenio, nombreMascota);
	}

	public Mascota buscarPorIdMascConDueActivo(Integer idMascota) {
		return mascotaDao.buscarPorIdMascConDueActivo(idMascota);
	}
	
	public void actualizarMascota(Integer idMascota, String nombreM, String alergico, String atencionEsp,
			String observaciones, String raza) {
		mascotaDao.actualizarMascota(idMascota, nombreM, alergico, atencionEsp, observaciones, raza);
	}

	public void eliminarMascota(String idMascota) {
		Integer idMas = Integer.parseInt(idMascota);
		mascotaDao.eliminarMascotaPorID(idMas);
	}

}
