package co.unal.sm.dtoFront;

import java.util.Date;
import java.util.List;

public class HogarFront {

	private Integer idHogar;
	private Integer idCliente;
	private String direccion;
	private Date fecha_registro;
	private String nombreCliente;
	private List<String> servicios;

	public Integer getIdHogar() {
		return idHogar;
	}

	public void setIdHogar(Integer idHogar) {
		this.idHogar = idHogar;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public List<String> getServicios() {
		return servicios;
	}

	public void setServicios(List<String> servicios) {
		this.servicios = servicios;
	}

}
