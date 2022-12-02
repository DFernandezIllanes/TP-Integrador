package ecommerce.msproductospersonalizados.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "producto_personalizado")
public class ProductoPersonalizado {
	
	//-------------------- Atributos -------------------------------------------
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nombre", columnDefinition = "VARCHAR(100)")
	private String nombre;
	
	@Column(name = "producto_base_id")
	private Long productoBaseId;
	
	@ManyToOne
	@JoinColumn(name = "vendedor_id", referencedColumnName = "id")
	@JsonBackReference
	private Vendedor vendedor;
	
	@OneToMany(mappedBy = "productoPersonalizado", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonManagedReference
	private List<Personalizacion> personalizaciones;
	
	//-------------------- Getters y Setters -------------------------------------

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

	public Long getProductoBaseId() {
		return productoBaseId;
	}

	public void setProductoBaseId(Long productoBaseId) {
		this.productoBaseId = productoBaseId;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}	
	
	public List<Personalizacion> getPersonalizaciones() {
		return new ArrayList<Personalizacion>(this.personalizaciones);
	}

	public void setPersonalizaciones(List<Personalizacion> personalizaciones) {
		this.personalizaciones = personalizaciones;
	}
	
	//-------------------- Constructores ---------------------------------------	

	public ProductoPersonalizado() {
		super();
		this.personalizaciones = new ArrayList<>();
	}

	public ProductoPersonalizado(String nombre, Long productoBaseId) {
		super();
		this.nombre = nombre;
		this.productoBaseId = productoBaseId;
		this.personalizaciones = new ArrayList<>();
	}

	public ProductoPersonalizado(Long id, String nombre, Long productoBaseId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.productoBaseId = productoBaseId;
		this.personalizaciones = new ArrayList<>();
	}

	public ProductoPersonalizado(String nombre, Long productoBaseId, Vendedor vendedor) {
		super();
		this.nombre = nombre;
		this.productoBaseId = productoBaseId;
		this.vendedor = vendedor;
		this.personalizaciones = new ArrayList<>();
	}

	public ProductoPersonalizado(Long id, String nombre, Long productoBaseId, Vendedor vendedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.productoBaseId = productoBaseId;
		this.vendedor = vendedor;
		this.personalizaciones = new ArrayList<>();
	}		
	
	public ProductoPersonalizado(String nombre, Long productoBaseId, Vendedor vendedor,
			List<Personalizacion> personalizaciones) {
		super();
		this.nombre = nombre;
		this.productoBaseId = productoBaseId;
		this.vendedor = vendedor;
		this.personalizaciones = personalizaciones;
	}
	
	public ProductoPersonalizado(Long id, String nombre, Long productoBaseId, Vendedor vendedor,
			List<Personalizacion> personalizaciones) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.productoBaseId = productoBaseId;
		this.vendedor = vendedor;
		this.personalizaciones = personalizaciones;
	}

	//-------------------- Métodos ---------------------------------------
	
	public void agregarPersonalizacion(Personalizacion personalizacion) {
		personalizacion.setProductoPersonalizado(this);
		this.personalizaciones.add(personalizacion);
	}
	
	
}
