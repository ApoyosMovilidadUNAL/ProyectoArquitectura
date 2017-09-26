package co.unal.sm.dto;

public class Usuario {

	private Integer id;
	private String clave;
	private Integer ht_persona_id;
	private String username;

	public Integer getHt_persona_id() {
		return ht_persona_id;
	}

	public void setHt_persona_id(Integer ht_persona_id) {
		this.ht_persona_id = ht_persona_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
