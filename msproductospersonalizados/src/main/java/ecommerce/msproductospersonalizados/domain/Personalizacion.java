package ecommerce.msproductospersonalizados.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "personalizacion")
public class Personalizacion {
	
	//------------------------ Atributos -------------------------------------------------
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nombre", columnDefinition = "VARCHAR(100)")
	private String nombre;
	
	@Column(name = "posible_personalizacion_id")
	private Long posiblePersonalizacionId;
	
	@Column(name = "precio")
	private Double precio;
	
	@Column(name = "contenido")
	private String contenido;
	
	@ManyToOne
	@JoinColumn(name = "producto_personalizado_id", referencedColumnName = "id")
	@JsonBackReference
	private ProductoPersonalizado productoPersonalizado;
	
	//------------------------ Getters y Setters -------------------------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getPosiblePersonalizacionId() {
		return posiblePersonalizacionId;
	}

	public void setPosiblePersonalizacionId(Long posiblePersonalizacionId) {
		this.posiblePersonalizacionId = posiblePersonalizacionId;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public ProductoPersonalizado getProductoPersonalizado() {
		return productoPersonalizado;
	}

	public void setProductoPersonalizado(ProductoPersonalizado productoPersonalizado) {
		this.productoPersonalizado = productoPersonalizado;
	}
	
	//------------------------ Constructores -------------------------------------------------
	
	public Personalizacion() {
		super();
	}
	
	public Personalizacion(String nombre, Long posiblePersonalizacionId, Double precio, String contenido) {
		super();
		this.nombre = nombre;
		this.posiblePersonalizacionId = posiblePersonalizacionId;
		this.precio = precio;
		this.contenido = contenido;
	}
	
	public Personalizacion(Long id, String nombre, Long posiblePersonalizacionId, Double precio, String contenido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posiblePersonalizacionId = posiblePersonalizacionId;
		this.precio = precio;
		this.contenido = contenido;
	}
	
	public Personalizacion(String nombre, Long posiblePersonalizacionId, Double precio, String contenido,
			ProductoPersonalizado productoPersonalizado) {
		super();
		this.nombre = nombre;
		this.posiblePersonalizacionId = posiblePersonalizacionId;
		this.precio = precio;
		this.contenido = contenido;
		this.productoPersonalizado = productoPersonalizado;
	}

	public Personalizacion(Long id, String nombre, Long posiblePersonalizacionId, Double precio, String contenido,
			ProductoPersonalizado productoPersonalizado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.posiblePersonalizacionId = posiblePersonalizacionId;
		this.precio = precio;
		this.contenido = contenido;
		this.productoPersonalizado = productoPersonalizado;
	}
	
	//------------------------ Métodos -------------------------------------------------	

}
