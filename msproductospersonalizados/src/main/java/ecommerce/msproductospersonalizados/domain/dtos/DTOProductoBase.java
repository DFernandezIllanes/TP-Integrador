package ecommerce.msproductospersonalizados.domain.dtos;

public class DTOProductoBase {
	
	//---------------------- Atributos -----------------------------------------------
	
		private String nombre;
		
		private Double precioBase;
		
		private String tiempoDeFabricacion;
		
		//--------------------- Getters y Setters ----------------------------------------

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

		public String getTiempoDeFabricacion() {
			return tiempoDeFabricacion;
		}

		public void setTiempoDeFabricacion(String tiempoDeFabricacion) {
			this.tiempoDeFabricacion = tiempoDeFabricacion;
		}
		
		//--------------------- Construtores ----------------------------------------
		
		public DTOProductoBase() {
			super();
		}
		
		public DTOProductoBase(String nombre, Double precioBase, String tiempoDeFabricacion) {
			super();
			this.nombre = nombre;
			this.precioBase = precioBase;
			this.tiempoDeFabricacion = tiempoDeFabricacion;
		}	

}
