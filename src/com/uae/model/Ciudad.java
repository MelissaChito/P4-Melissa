package com.uae.model;

public class Ciudad<Integer, String> {
	
	private Integer idCiudad;
	private String nombre;
	private String pais;
	
	
	public Ciudad() {
		super();
	}

	public Ciudad(Integer idCiudad, String nombre, String pais) {
		super();
		this.idCiudad = idCiudad;
		this.nombre = nombre;
		this.pais = pais;
	}
	
	public Integer getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Integer idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	

}
