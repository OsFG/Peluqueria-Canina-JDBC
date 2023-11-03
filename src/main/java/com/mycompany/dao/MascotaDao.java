package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;

import com.mycompany.modelo.cita.Cita;
import com.mycompany.modelo.duenio.Duenio;
import com.mycompany.modelo.mascota.Mascota;

public class MascotaDao {
	
 //	ATRIBUTOS
	private Connection conexion;

 // CONSTRUCTORES	
	public MascotaDao(Connection conexion) {
		this.conexion = conexion;
	}
	
	
 // MÉTODOS
	
	/* Método para Guardar a Mascota: 
	   Primero, en el View se debe llamar al Método para buscar al DuenioDao por Nombre y para obtener su Id
	   Segundo, si lo encuentra, le extrae el Id de la DB y se guarda en a la Entidad Mascota para después pasarlo a MascotaDao;
		 	si no encuentra a un Duenio, se debe ejecutar el Método para guardar al Duenio y después extraer su Id */	
	public void guardar(Mascota mascota) {
		try {
			conexion.setAutoCommit(false);
			
			PreparedStatement statement = conexion.prepareStatement(
					"INSERT INTO TBMASCOTAS"
				  + "(nombreMascota, raza, color, alergico, atencionEspecial, observaciones, idDuenio)"
				  +	"VALUES (?, ?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			try(statement){
				statement.setString(1, mascota.getNombreMascota());
				statement.setString(2, mascota.getRaza().toString());
				statement.setString(3, mascota.getColor());
				statement.setString(4, mascota.getAlergico());
				statement.setString(5, mascota.getAtencionEspecial());
				statement.setString(6, mascota.getObservaciones());
				statement.setInt(7, mascota.getIdDuenio());
				
				statement.executeUpdate();
				conexion.commit();
			}	
				
				final ResultSet resultSet = statement.getGeneratedKeys();
				try(resultSet){ 
					while (resultSet.next()) {							 
						mascota.setId(resultSet.getInt(1));
			//			System.out.println(String.format("Fue insertada la mascota %s", mascota)); 
						}
				}				
			
			conexion.setAutoCommit(true);			
		} catch (SQLException e) {
			try {
				conexion.rollback();
				conexion.setAutoCommit(true);
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
		  throw new RuntimeException(e);
		}				 	
	}

	
	public Mascota buscarMascotaPorNombreMascotaYIdDuenio(String nombre, Integer idDuenio) {
		Mascota mascota = null;
		
		PreparedStatement statement;
		try {
			statement = conexion.prepareStatement("SELECT * FROM TBMASCOTAS "
													+ "WHERE nombreMascota = ? AND idDuenio = ?");
			try(statement){
				statement.setString(1, nombre);
				statement.setInt(2, idDuenio);
				
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while (resultSet.next()) {
						Integer id = resultSet.getInt("idMascota");				
						String raza = resultSet.getString("raza");
						String alergico = resultSet.getString("alergico");
						String atencionEspecial = resultSet.getString("atencionEspecial");
						String observaciones = resultSet.getString("observaciones");
						
						mascota = new Mascota(id, raza, alergico, atencionEspecial, observaciones);	
					}
				}
			}
			return mascota;			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Mascota buscarMascotaPorIds(Integer idDuenio, Integer idMascota) {
		Mascota mascota = null;
		
		try {
			PreparedStatement statement = conexion.prepareStatement("SELECT * FROM TBMASCOTAS "
					+ "WHERE idMascota = ? AND idDuenio = ?");
			try(statement){
				statement.setInt(1, idMascota);
				statement.setInt(2, idDuenio);
				
				statement.execute();
				ResultSet resultSet = statement.getResultSet();
				
				try(resultSet){
					while(resultSet.next()) {
						String nombreMascota = resultSet.getString("nombreMascota");
						String raza = resultSet.getString("raza");
						String color = resultSet.getString("color");
						String alergico = resultSet.getString("alergico");
						String atencionEspecial = resultSet.getString("atencionEspecial");
						String observaciones = resultSet.getString("observaciones");
						
						mascota = new Mascota(idMascota, nombreMascota, color, raza, alergico, atencionEspecial, observaciones, idDuenio);
					}
				}
			
			}				
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		return mascota;
	}	
	
	public Mascota buscarMascotaPorIdDYNombreM(Integer idDuenio, String nombreMascota) {
		Mascota mascota = null;
		
		try {
			PreparedStatement statement = conexion.prepareStatement("SELECT * FROM TBMASCOTAS "
											+ "WHERE idDuenio = ? AND nombreMascota = ?");
			try(statement){
				statement.setInt(1, idDuenio);
				statement.setString(2, nombreMascota);
				
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while (resultSet.next()){
						Integer idMascota = resultSet.getInt("idMascota");
						String raza = resultSet.getString("raza");
						String color = resultSet.getString("color");
						String alergico = resultSet.getString("alergico");
						String atencionEspecial = resultSet.getString("atencionEspecial");
						String observaciones = resultSet.getString("observaciones");
						
						mascota = new Mascota(idMascota, nombreMascota, color, raza, alergico, atencionEspecial, observaciones, idDuenio);
						}
				}
			}			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return mascota;
	}

	public void actualizarMascota(Integer idMascota, String nombreM, String alergico, String atencionEsp,
			String observaciones, String raza) {
		try {
			conexion.setAutoCommit(false);
			PreparedStatement statement = conexion.prepareStatement("UPDATE TBMASCOTAS SET "
											+ "nombreMascota=?, "
											+ "raza =?, "
											+ "alergico=?, "
											+ "atencionEspecial=?, "
											+ "observaciones=? "
											+ "WHERE idMascota = ?");
			try(statement){
				statement.setString(1, nombreM);
				statement.setString(2, raza);
				statement.setString(3, alergico);
				statement.setString(4, atencionEsp);
				statement.setString(5, observaciones);
				statement.setInt(6, idMascota);
				
				statement.execute();
			}
			conexion.commit();
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


	public void eliminarMascotaPorID(Integer idMascota) {
		try {
			conexion.setAutoCommit(false);
			
			PreparedStatement statement = conexion.prepareStatement("DELETE FROM TBMASCOTAS "
					+ "WHERE idMascota= ?");
			
			try(statement){
				statement.setInt(1, idMascota);
				
				statement.execute();
			}
			conexion.commit();
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
	
	
	public Mascota buscarPorIdMascConDueActivo(Integer idMascota) {
		Mascota mascota = null;
		
		PreparedStatement statement;
		try {
			statement = conexion.prepareStatement("SELECT m.raza, m.nombreMascota "
												  + "FROM (TBMASCOTAS m INNER JOIN TBDUENIOS d ON m.idDuenio = d.idDuenio)"
												  + " WHERE m.idMascota = ? AND d.activo = 1");
			try(statement){
				statement.setInt(1, idMascota);
				
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while (resultSet.next()) {
						String nombreM = resultSet.getString("m.nombreMascota");
						String raza = resultSet.getString("m.raza");
						
						mascota = new Mascota(idMascota, nombreM, raza);	
					}
				}
			}	
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		return mascota;
	}

}
