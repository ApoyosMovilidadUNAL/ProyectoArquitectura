package co.unal.sm.dto;

import java.util.Date;

public class Hogar {

	private Integer id;
	private String direccion;
	private String ubicacion;
	private Integer ht_clente_id;
	private Date fecha_registro;
	private String fecha_json;

	public Integer getHt_clente_id() {
		return ht_clente_id;
	}

	public void setHt_clente_id(Integer ht_clente_id) {
		this.ht_clente_id = ht_clente_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getFecha_json() {
		return fecha_json;
	}

	public void setFecha_json(String fecha_json) {
		this.fecha_json = fecha_json;
	}

}
