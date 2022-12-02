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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "vendedor")
public class Vendedor {
	
	//------------------ ATRIBUTOS ------------------------------------
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nombre", columnDefinition = "VARCHAR(50)")
	private String nombre;
	
	@Column(name = "apellido", columnDefinition = "VARCHAR(50)")
	private String apellido;
	
	@OneToMany(mappedBy = "vendedor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonManagedReference
	private List<ProductoPersonalizado> productosPersonalizados;	
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "tienda_id", referencedColumnName = "id")
	private Tienda tienda;
	
	//------------------ GETTERS Y SETTERS ------------------------------------
	
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public List<ProductoPersonalizado> getProductosPersonalizados() {
		return new ArrayList<ProductoPersonalizado>(this.productosPersonalizados);
	}

	public void setProductosPersonalizados(List<ProductoPersonalizado> productosPersonalizados) {
		this.productosPersonalizados = productosPersonalizados;
	}	
	
	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	
	//------------------ CONSTRUCTORES ------------------------------------

	public Vendedor() {
		super();		
		this.productosPersonalizados = new ArrayList<>();
		this.tienda = new Tienda(this);
	}
	
	public Vendedor(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.productosPersonalizados = new ArrayList<>();
		this.tienda = new Tienda(this);
	}
	
	public Vendedor(String nombre, String apellido, List<ProductoPersonalizado> productosPersonalizados) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.productosPersonalizados = productosPersonalizados;
		this.tienda = new Tienda(this);
	}
	
	public Vendedor(Long id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.productosPersonalizados = new ArrayList<>();
		this.tienda = new Tienda(this);
	}
	
	public Vendedor(Long id, String nombre, String apellido, List<ProductoPersonalizado> productosPersonalizados) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.productosPersonalizados = productosPersonalizados;
		this.tienda = new Tienda(this);
	}	
	
	public Vendedor(Long id, String nombre, String apellido, List<ProductoPersonalizado> productosPersonalizados,
			Tienda tienda) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.productosPersonalizados = productosPersonalizados;
		this.tienda = tienda;
	}

	//------------------ MÉTODOS ------------------------------------
	
	public void agregarProductoPersonalizado(ProductoPersonalizado productoPersonalizado) {
		productoPersonalizado.setVendedor(this);
		this.productosPersonalizados.add(productoPersonalizado);
	}
}
