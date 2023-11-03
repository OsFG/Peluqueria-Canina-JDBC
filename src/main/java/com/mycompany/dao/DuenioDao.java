package com.mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;

import com.mycompany.modelo.duenio.Duenio;

public class DuenioDao {
	
//	ATRIBUTOS
	private Connection conexion;

 // CONSTRUCTORES		
	public DuenioDao(Connection conexion) {
		this.conexion = conexion;		
	}
	
	
	public void guardar(Duenio duenio) {
		
		try {
			conexion.setAutoCommit(false);
			
			PreparedStatement statement = conexion.prepareStatement("INSERT INTO TBDUENIOS"
					+ "(nombreDuenio, telefono, direccion, activo)"
					+ "vALUES (?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			
			try(statement){
				statement.setString(1, duenio.getNombreDuenio());
				statement.setString(2, duenio.getTelefono());
				statement.setString(3, duenio.getDireccion());
				statement.setBoolean(4, duenio.getActivo());
				
				statement.executeUpdate();
			}	
				conexion.commit();
				conexion.setAutoCommit(true);
				
				ResultSet resultSet = statement.getGeneratedKeys();
				try(resultSet){
					while(resultSet.next()){
						duenio.setIdDuenio(resultSet.getInt(1));
						System.out.println(String.format("Se registro al Dueño %s", duenio));
					}
				}
						
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


	public Duenio buscarPorNombreYTelefono(String nombreDuenio, String telefono) {
		Duenio duenio = null;
		try {
			PreparedStatement statement = conexion.prepareStatement("SELECT * FROM TBDUENIOS WHERE nombreDuenio = ? AND telefono = ?");
			
			try(statement){
				statement.setString(1, nombreDuenio);
				statement.setString(2, telefono);
				statement.execute();
				
				ResultSet resultSet = statement.getResultSet();
				try(resultSet){
					while (resultSet.next()) {
						Integer id = resultSet.getInt("idDuenio");
						String nombre = resultSet.getString("nombreDuenio");
						String tel = resultSet.getString("telefono");
						String direccion = resultSet.getString("direccion");
						
						duenio = new Duenio(id, nombre, tel, direccion);	
					}
				}
			}			
			return duenio;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


	public void actualizarPorId(Integer idDuenio, String nombreDuenio, String telefono, String direccion){
		try {
			conexion.setAutoCommit(false);
			
			PreparedStatement statement = conexion.prepareStatement("UPDATE TBDUENIOS SET "
					+ "nombreDuenio = ?, "
					+ "telefono = ?, "
					+ "direccion = ? "
					+ "WHERE idDuenio = ?");
			try(statement){
				statement.setString(1, nombreDuenio);
				statement.setString(2, telefono);
				statement.setString(3, direccion);
				statement.setInt(4, idDuenio);
				
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


	public void eliminarPorId(Integer idDuenio) {		
		try {
			conexion.setAutoCommit(false);
			
			PreparedStatement statement = conexion.prepareStatement("UPDATE TBDUENIOS SET "
					+ "activo = 0 WHERE idDuenio = ?");
			
			try(statement){
				statement.setInt(1, idDuenio);
				
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

}
