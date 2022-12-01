package ecommerce.msproductosbase.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto_base")
public class ProductoBase {
	
	//------------------- Atributos ------------------------------------------------
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nombre", columnDefinition = "VARCHAR(100)")
	private String nombre;
	
	@Column(name = "precio_base")
	private Double precioBase;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "tiempo_de_fabricacion", columnDefinition = "VARCHAR(50)")
	private String tiempoDeFabricacion;
	
	@ManyToOne
	@JoinColumn(name = "gestor_id", referencedColumnName = "id")
	private Gestor gestor;
	
	//------------------- Getters y Setters ------------------------------------------------

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

	public Double getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(Double precioBase) {
		this.precioBase = precioBase;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTiempoDeFabricacion() {
		return tiempoDeFabricacion;
	}

	public void setTiempoDeFabricacion(String tiempoDeFabricacion) {
		this.tiempoDeFabricacion = tiempoDeFabricacion;
	}
	
	public Gestor getGestor() {
		return gestor;
	}

	public void setGestor(Gestor gestor) {
		this.gestor = gestor;
	}
	
	//------------------- Constructores ------------------------------------------------

	public ProductoBase() {
		super();
	}	

	public ProductoBase(String nombre, Double precioBase, String descripcion, String tiempoDeFabricacion) {
		super();
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.descripcion = descripcion;
		this.tiempoDeFabricacion = tiempoDeFabricacion;
	}

	public ProductoBase(String nombre, Double precioBase, String descripcion, String tiempoDeFabricacion,
			Gestor gestor) {
		super();
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.descripcion = descripcion;
		this.tiempoDeFabricacion = tiempoDeFabricacion;
		this.gestor = gestor;
	}

	public ProductoBase(Long id, String nombre, Double precioBase, String descripcion, String tiempoDeFabricacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.descripcion = descripcion;
		this.tiempoDeFabricacion = tiempoDeFabricacion;
	}

	public ProductoBase(Long id, String nombre, Double precioBase, String descripcion, String tiempoDeFabricacion,
			Gestor gestor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precioBase = precioBase;
		this.descripcion = descripcion;
		this.tiempoDeFabricacion = tiempoDeFabricacion;
		this.gestor = gestor;
	}
	
//	public void actualizar(ProductoBase producto) {
//		this.nombre = producto.getNombre().equals("") ? this.nombre : producto.getNombre();
//		this.precioBase = producto.getPrecioBase().isNaN() ? this.precioBase : producto.getPrecioBase();
//		this.descripcion = producto.getDescripcion().equals("") ? this.descripcion : producto.getDescripcion();
//		this.tiempoDeFabricacion = producto.getTiempoDeFabricacion().equals("") ? this.tiempoDeFabricacion : producto.getTiempoDeFabricacion();
//	}

}
