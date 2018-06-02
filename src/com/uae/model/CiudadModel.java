package com.uae.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CiudadModel {
	

	public <ArrayList> <Ciudad> getAll(){
		Connection conn = null;
		ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
		try {
			conn = new ConexionBDD().getConnection();
			 String sql = "Select * from Ciudad";
 			 System.out.println(sql);

			  ResultSet rs = conn.createStatement().executeQuery(sql);
	            while (rs.next()) {       
	            	Ciudad a = new Ciudad();
	                a.setIdCiudad(rs.getInt("idCiudad"));
	                a.setNombre(rs.getString("nombre"));
	                a.setPais(rs.getString("pais"));
	                ciudades.add(a);
	            }

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return ciudades;
		
	}
	
	public void insert(Ciudad ciudad) {
		Connection conn = null;
		try {
			conn = new ConexionBDD().getConnection();
			String insert = "INSERT INTO Ciudad (nombre,pais) "
					+ " values (?,?)";
		    
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, ciudad.getPais());
			
			System.out.println(insert);
			System.out.println("1) "+ciudad.getNombre());
			System.out.println("2) "+ciudad.getPais());
			
			//Ejecutamos el query en la base de datos
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// Codigo que siempre se ejecutara
			// Se debe cerrar siempre la conexion a BDD
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void update(Ciudad ciudad) {
		Connection conn = null;
		try {
			conn = new ConexionBDD().getConnection();
			String update = "UPDATE Ciudad set nombre = ? , pais = ?  Where idCiudad = ?";
			PreparedStatement ps = conn.prepareStatement(update);
			ps.setString(1, ciudad.getNombre());
			ps.setString(2, ciudad.getPais());
			ps.setInt(3, ciudad.getIdCiudad());
			
			System.out.println(update);
			System.out.println("1) "+ciudad.getNombre());
			System.out.println("2) "+ciudad.getPais());
			System.out.println("3) "+ciudad.getIdCiudad());

			//Ejecutamos el query en la base de datos
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	


}
