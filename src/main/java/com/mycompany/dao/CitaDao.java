package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

import com.mycompany.modelo.cita.Cita;
import com.mycompany.modelo.duenio.Duenio;
import com.mycompany.modelo.mascota.Mascota;


public class CitaDao {
	
// ATRIBUTOS
	private Connection conexion;

// CONSTRUTORES
	public CitaDao(Connection conexion) {
		this.conexion = conexion;
		
	}

// MÉTODOS	
	public Cita buscarInnerJoinIdDYNombreMascota(Integer idDuenio, String nombreMascota) {
		Cita cita = null;
		
		try {
			PreparedStatement statement = conexion.prepareStatement(
											"SELECT c.idCita, c.idMascota, c.citaAgendada, "
											+ "m.raza, "
											+ "d.nombreDuenio, d.telefono "
											+ "FROM (TBCITAS c INNER JOIN TBMASCOTAS m ON c.idMascota = m.idMascota) "
											+ "INNER JOIN TBDUENIOS d ON m.idDuenio = d.idDuenio "
											+ "WHERE c.citaActiva = 1 AND m.idDuenio = ? AND m.nombreMascota = ?");
			try(statement){
				statement.setInt(1, idDuenio);
				statement.setString(2, nombreMascota);
				
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while(resultSet.next()) {
						Integer idCita = resultSet.getInt("c.idCita");
						Integer idMascota = resultSet.getInt("c.idMascota");
						LocalDateTime citaAgendada = LocalDateTime.parse(resultSet.getObject("c.citaAgendada").toString());
						
						String raza = resultSet.getString("m.raza");
						
						String nombreDuenio = resultSet.getString("d.nombreDuenio");
						String telefono = resultSet.getString("d.telefono");
						
						
						cita = new Cita(idCita, idMascota, citaAgendada);
						cita.setMascota(new Mascota(idMascota, nombreMascota, raza, idDuenio));
						cita.setDuenio(new Duenio(idDuenio, nombreDuenio, telefono));
					}
				}
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return cita;
	}

	public Cita buscarInnerJoinIds(Integer idDuenio, Integer idMascota) {
		Cita cita = null;
		
		try {
			PreparedStatement statement = conexion.prepareStatement(
											"SELECT c.idCita, c.citaAgendada, "
											+ "m.nombreMascota, m.raza, "
											+ "d.nombreDuenio, d.telefono "
											+ "FROM (TBCITAS c INNER JOIN TBMASCOTAS m ON c.idMascota = m.idMascota)"
											+ "INNER JOIN TBDUENIOS d ON m.idDuenio = d.idDuenio "
											+ "WHERE c.citaActiva = 1 AND m.idDuenio = ? AND m.idMascota = ?");
			try(statement){
				statement.setInt(1, idDuenio);
				statement.setInt(2, idMascota);
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while(resultSet.next()) {
						Integer idCita = resultSet.getInt("c.idCita");
						LocalDateTime citaAgendada = LocalDateTime.parse(resultSet.getObject("c.citaAgendada").toString());
						
						String nombreMascota = resultSet.getString("m.nombreMascota");
						String raza = resultSet.getString("m.raza");
						
						String nombreDuenio = resultSet.getString("d.nombreDuenio");
						String telefono = resultSet.getString("d.telefono");
						
						cita = new Cita(idCita, idMascota, citaAgendada);
						cita.setMascota(new Mascota(idMascota, nombreMascota, raza, idDuenio));
						cita.setDuenio(new Duenio(idDuenio, nombreDuenio, telefono));
					}				
				}
			}
						
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return cita;
	}

	public Cita buscarInnerJoinNombreDuenioYIdMascota(String nombreDuenio, Integer idMascota) {
		Cita cita = null;
		
		try {
			PreparedStatement statement = conexion.prepareStatement(
											"SELECT c.idCita, c.citaAgendada, "
											+ "m.nombreMascota, m.raza, "
											+ "d.idDuenio, d.telefono "
											+ "FROM (TBCITAS c INNER JOIN TBMASCOTAS m ON c.idMascota = m.idMascota) "
											+ "INNER JOIN TBDUENIOS d ON m.idDuenio = d.idDuenio "
											+ "WHERE c.citaActiva = 1 AND d.nombreDuenio = ? AND c.idMascota = ?");
			try(statement){
				statement.setString(1, nombreDuenio);
				statement.setInt(2, idMascota);
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while(resultSet.next()){
						Integer idCita = resultSet.getInt("c.idCita");
						LocalDateTime citaAgendada = LocalDateTime.parse(resultSet.getObject("c.citaAgendada").toString());
						
						String nombreMascota = resultSet.getString("m.nombreMascota");
						String raza = resultSet.getString("m.raza");
						
						Integer idDuenio = resultSet.getInt("d.idDuenio");
						String telefono = resultSet.getString("d.telefono");
						
						cita = new Cita(idCita, idMascota, citaAgendada);
						cita.setMascota(new Mascota(idMascota, nombreMascota, raza, idDuenio));
						cita.setDuenio(new Duenio(idDuenio, nombreDuenio, telefono));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		return cita;
	}

	public Cita buscarIdCita(Integer idCita) {
		Cita cita = null;
		
		try {
			PreparedStatement statement = conexion.prepareStatement(
											"SELECT c.idMascota, c.citaAgendada, "
											+ "m.nombreMascota, m.raza, "
											+ "d.idDuenio, d.nombreDuenio, d.telefono "
											+ "FROM (TBCITAS c INNER JOIN TBMASCOTAS m ON c.idMascota = m.idMascota) "
											+ "INNER JOIN TBDUENIOS d ON m.idDuenio = d.idDuenio "
											+ "WHERE c.citaActiva = 1 AND c.idCita = ?");
			try(statement){
				statement.setInt(1, idCita);
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while(resultSet.next()) {
						Integer idMascota = resultSet.getInt("c.idMascota");
						LocalDateTime citaAgendada = LocalDateTime.parse(resultSet.getObject("c.citaAgendada").toString());
						
						String nombreMascota = resultSet.getString("m.nombreMascota");
						String raza = resultSet.getString("m.raza");
						
						Integer idDuenio = resultSet.getInt("d.idDuenio");
						String nombreDuenio = resultSet.getString("d.nombreDuenio");
						String telefono = resultSet.getString("d.telefono");
						
						cita = new Cita(idCita, idMascota, citaAgendada);
						cita.setMascota(new Mascota(idMascota, nombreMascota, raza, idDuenio));
						cita.setDuenio(new Duenio(idDuenio, nombreDuenio, telefono));
					}				
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		return cita;
	}
	
	
	public Cita buscarCitaActivaPorFechaYIdMascota(LocalDateTime fechaYHoraLD, Integer idMascota) {
Cita cita = null;
		
		try {
			PreparedStatement statement = conexion.prepareStatement(
											"SELECT * FROM TBCITAS "
											+ "WHERE citaActiva = 1 AND citaAgendada= ? AND idMascota = ?");
			try(statement){
				statement.setObject(1, fechaYHoraLD);
				statement.setInt(2, idMascota);
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while(resultSet.next()){
						Integer idCita = resultSet.getInt("idCita");
											cita = new Cita(idCita, idMascota, fechaYHoraLD);
					}
				}
			}				
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		return cita;
	}

	public void agendarCita(Cita cita) {		
		try {
			conexion.setAutoCommit(false);
			PreparedStatement statement = conexion.prepareStatement("INSERT INTO TBCITAS"
																	+ "(idMascota, citaAgendada)"
																	+ "VALUES (?,?)",
																	Statement.RETURN_GENERATED_KEYS);
			try(statement){
				statement.setInt(1, cita.getIdMascota());
				statement.setObject(2, cita.getCitaAgendada());
				statement.execute();
				
				conexion.commit();
				
				ResultSet resultSet = statement.getGeneratedKeys();
				
				try(resultSet){
					while(resultSet.next()) {
						cita.setIdCita(resultSet.getInt(1));					
						}
				}				
			}
			conexion.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conexion.rollback();
				conexion.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		}
	}

	public void modificarCita(Integer idCita, LocalDateTime fechaYHora) {
		try {
			conexion.setAutoCommit(false);
			
			PreparedStatement statement = conexion.prepareStatement("UPDATE TBCITAS "
														+ "SET citaAgendada = ? "
														+ "WHERE idCita = ?");
			try(statement){
				statement.setObject(1, fechaYHora);
				statement.setInt(2, idCita);
				
				statement.execute();
				conexion.commit();
			}
			conexion.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				conexion.rollback();
				conexion.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		}
	}

	public void eliminarCita(Integer idCita) {
		
		try {
			conexion.setAutoCommit(false);
			
			PreparedStatement statement = conexion.prepareStatement("UPDATE TBCITAS SET citaActiva = 0 "
														+ "WHERE idCita = ?");
			try(statement){
				statement.setInt(1, idCita);
				statement.execute();
				
				conexion.commit();
			}
			conexion.setAutoCommit(true);
			
		} catch (SQLException e) {
			try {
				conexion.rollback();
				conexion.setAutoCommit(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new RuntimeException(e);
		}
	}
	
}












