package ecommerce.msproductospersonalizados.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tienda")
public class Tienda {
	
	//-------------------- ATRIBUTOS -------------------------------------------
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "vendedor_id", referencedColumnName = "id")
	private Vendedor vendedor;
	
	//-------------------- GETTERS Y SETTERS -----------------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	//-------------------- CONSTRUCTORES -----------------------------------
	
	public Tienda() {
		super();
	}
	
	public Tienda(Vendedor vendedor) {
		super();
		this.vendedor = vendedor;
	}

	public Tienda(Long id, Vendedor vendedor) {
		super();
		this.id = id;
		this.vendedor = vendedor;
	}
	
	//-------------------- MÉTODOS -----------------------------------
	
	
	
	

}
