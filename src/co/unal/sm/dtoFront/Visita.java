package co.unal.sm.dtoFront;

import java.util.Date;

public class Visita {

	private String estado_servicio;
	private Date fecha_visita;
	private String direccion;
	private String nombreCliente;
	private String nombreServicio;
	private Integer id_cliente;
	private Integer id_hogar;
	private Integer id_servicio;

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getId_hogar() {
		return id_hogar;
	}

	public void setId_hogar(Integer id_hogar) {
		this.id_hogar = id_hogar;
	}

	public Integer getId_servicio() {
		return id_servicio;
	}

	public void setId_servicio(Integer id_servicio) {
		this.id_servicio = id_servicio;
	}

	public String getEstado_servicio() {
		return estado_servicio;
	}

	public void setEstado_servicio(String estado_servicio) {
		this.estado_servicio = estado_servicio;
	}

	public Date getFecha_visita() {
		return fecha_visita;
	}

	public void setFecha_visita(Date fecha_visita) {
		this.fecha_visita = fecha_visita;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

}
