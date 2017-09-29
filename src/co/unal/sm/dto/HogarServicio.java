package co.unal.sm.dto;

import java.util.Date;

public class HogarServicio {

	private String estado_servicio;
	private Integer ht_hogar_id;
	private Integer ht_servicio_id;
	private Date fecha_visita;
	private Date fecha_retiro;

	public Integer getHt_hogar_id() {
		return ht_hogar_id;
	}

	public void setHt_hogar_id(Integer ht_hogar_id) {
		this.ht_hogar_id = ht_hogar_id;
	}

	public Integer getHt_servicio_id() {
		return ht_servicio_id;
	}

	public void setHt_servicio_id(Integer ht_servicio_id) {
		this.ht_servicio_id = ht_servicio_id;
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

	public Date getFecha_retiro() {
		return fecha_retiro;
	}

	public void setFecha_retiro(Date fecha_retiro) {
		this.fecha_retiro = fecha_retiro;
	}

}
