package ecommerce.msproductosbase.app;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "gestor")
public class Gestor {
	
	//---------------- Atributos --------------------------------------------------
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nombre", columnDefinition = "VARCHAR(50)")
	private String nombre;
	
	@Column(name = "apellido", columnDefinition = "VARCHAR(50)")
	private String apellido;
	
	@OneToMany(mappedBy = "gestor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<ProductoBase> productosBase;
	
	//---------------- Getters y Setters --------------------------------------------------

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
	
	public List<ProductoBase> getProductosBase() {
		return new ArrayList<ProductoBase>(this.productosBase);
	}

	public void setProductosBase(List<ProductoBase> productosBase) {
		this.productosBase = productosBase;
	}
	
	public void agregarProductoBase(ProductoBase productoBase) {
		productoBase.setGestor(this);
		this.productosBase.add(productoBase);
	}
	
	//---------------- Constructores --------------------------------------------------	

	public Gestor() {
		super();
		this.productosBase = new ArrayList<>();
	}
	
	public Gestor(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.productosBase = new ArrayList<>();
	}

	public Gestor(Long id, String nombre, String apellido) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.productosBase = new ArrayList<>();
	}

	public Gestor(Long id, String nombre, String apellido, List<ProductoBase> productosBase) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.productosBase = productosBase;
	}	
	
	

}
