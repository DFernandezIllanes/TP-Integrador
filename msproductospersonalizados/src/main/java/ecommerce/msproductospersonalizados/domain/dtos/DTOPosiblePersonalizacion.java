package ecommerce.msproductospersonalizados.domain.dtos;

public class DTOPosiblePersonalizacion {
	
	//-------------------- Atributos --------------------------------------------
	
	private String areaDePersonalizacion;
	
	private String tipoDePersonalizacion;
	
	//-------------------- Getters y Setters --------------------------------------------

	public String getAreaDePersonalizacion() {
		return areaDePersonalizacion;
	}

	public void setAreaDePersonalizacion(String areaDePersonalizacion) {
		this.areaDePersonalizacion = areaDePersonalizacion;
	}

	public String getTipoDePersonalizacion() {
		return tipoDePersonalizacion;
	}

	public void setTipoDePersonalizacion(String tipoDePersonalizacion) {
		this.tipoDePersonalizacion = tipoDePersonalizacion;
	}	
	
	//-------------------- Constructores --------------------------------------------
	
	public DTOPosiblePersonalizacion() {
		super();
	}
	
	public DTOPosiblePersonalizacion(String areaDePersonalizacion) {
		super();
		this.areaDePersonalizacion = areaDePersonalizacion;
	}
	
	public DTOPosiblePersonalizacion(String areaDePersonalizacion, String tipoDePersonalizacion) {
		super();
		this.areaDePersonalizacion = areaDePersonalizacion;
		this.tipoDePersonalizacion = tipoDePersonalizacion;
	}

}
