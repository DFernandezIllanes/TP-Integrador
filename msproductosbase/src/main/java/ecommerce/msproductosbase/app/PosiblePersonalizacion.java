package ecommerce.msproductosbase.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ecommerce.msproductosbase.app.dtos.DTOPosiblePersonalizacion;

@Entity
@Table(name = "posible_personalizacion")
public class PosiblePersonalizacion {
	
	//------------- Atributos --------------------------------------------------
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "area_de_personalizacion", columnDefinition = "VARCHAR(100)")
	private String areaDePersonalizacion;
	
	@Column(name = "tipo_de_personalizacion", columnDefinition = "VARCHAR(100)")
	private String tipoDePersonalizacion;
	
	@ManyToOne
	@JoinColumn(name = "producto_base_id", referencedColumnName = "id")
	@JsonBackReference
	private ProductoBase productoBase;

	//------------- Getters y Setters ------------------------------------------
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public ProductoBase getProductoBase() {
		return productoBase;
	}

	public void setProductoBase(ProductoBase productoBase) {
		this.productoBase = productoBase;
	}	
	
	//--------------- Constructores ---------------------------------------------
	
	public PosiblePersonalizacion() {
		super();
	}

	public PosiblePersonalizacion(String areaDePersonalizacion, String tipoDePersonalizacion) {
		super();
		this.areaDePersonalizacion = areaDePersonalizacion;
		this.tipoDePersonalizacion = tipoDePersonalizacion;
	}

	public PosiblePersonalizacion(Long id, String areaDePersonalizacion, String tipoDePersonalizacion) {
		super();
		this.id = id;
		this.areaDePersonalizacion = areaDePersonalizacion;
		this.tipoDePersonalizacion = tipoDePersonalizacion;
	}

	public PosiblePersonalizacion(String areaDePersonalizacion, String tipoDePersonalizacion,
			ProductoBase productoBase) {
		super();
		this.areaDePersonalizacion = areaDePersonalizacion;
		this.tipoDePersonalizacion = tipoDePersonalizacion;
		this.productoBase = productoBase;
	}

	public PosiblePersonalizacion(Long id, String areaDePersonalizacion, String tipoDePersonalizacion,
			ProductoBase productoBase) {
		super();
		this.id = id;
		this.areaDePersonalizacion = areaDePersonalizacion;
		this.tipoDePersonalizacion = tipoDePersonalizacion;
		this.productoBase = productoBase;
	}
	
	//--------------- Métodos ---------------------------------------------
	
	public DTOPosiblePersonalizacion toDTOPosiblePersonalizacion() {
		return new DTOPosiblePersonalizacion(this.areaDePersonalizacion, this.tipoDePersonalizacion);
	}
	
}
