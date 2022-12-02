package ecommerce.msproductospersonalizados.domain;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.msproductospersonalizados.domain.dtos.DTOPosiblePersonalizacion;
import ecommerce.msproductospersonalizados.domain.dtos.DTOProductoBase;

@RestController
public class VendedorController {
	
	@Autowired
	MSProductosBaseProxy proxy;
	
	@Autowired
	RepoVendedor repoVendedor;
	
	@Autowired
	RepoProductoPersonalizado repoProductoPersonalizado;
	
	//----------------- Métodos de Productos Personalizados ----------------------------
	
//	@GetMapping("/vendedores/{vendedorId}/productos/{productoPersonalizadoId}")
//	public DTOProductoBase esIgual(
//			@PathVariable("vendedorId") Long vendedorId,
//			@PathVariable("productoPersonalizadoId") Long productoPersonalizadoId) {
//		
//		DTOProductoBase respuesta = proxy.chequearProductoBase(productoPersonalizadoId);
//		
//		return respuesta;
//		
//	}
	
	@Transactional
	@PostMapping("/vendedores/{vendedorId}/productos-personalizados")
	public @ResponseBody ResponseEntity<Object> crearProductoPersonalizado(
			@PathVariable("vendedorId") Long vendedorId,
			@RequestBody(required = true) ProductoPersonalizado productoPersonalizado) {
		
		Optional<Vendedor> vendedorOptional = repoVendedor.findById(vendedorId);
		
		if(vendedorOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe el vendedor");
		} else {
			
			Long productoBaseId = productoPersonalizado.getProductoBaseId();
			
			DTOProductoBase productoBase = proxy.chequearProductoBase(productoBaseId);
			
			if(productoBase.getNombre().equals("no existe")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe el producto base");
			} else {
				
				Vendedor vendedor = vendedorOptional.get();
				
				vendedor.agregarProductoPersonalizado(productoPersonalizado);
				
				return ResponseEntity.status(HttpStatus.OK).body(productoPersonalizado);
			}
		}
	}
	
	//----------------- Métodos de Personalizaciones ----------------------------

	@Transactional
	@PostMapping("/vendedores/{vendedorId}/productos-personalizados/{productoPersonalizadoId}/personalizaciones")
	public @ResponseBody ResponseEntity<Object> crearPersonalizacion(
			@PathVariable("vendedorId") Long vendedorId,
			@PathVariable("productoPersonalizadoId") Long productoPersonalizadoId,
			@RequestBody(required = true) Personalizacion personalizacion) {
		
		Optional<Vendedor> vendedorOptional = repoVendedor.findById(vendedorId);
		Optional<ProductoPersonalizado> productoPersonalizadoOptional = repoProductoPersonalizado.findById(productoPersonalizadoId);
		
		if(vendedorOptional.isEmpty() || productoPersonalizadoOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No existe el vendedor o el producto personalizado");
		} else {
			
			ProductoPersonalizado productoPersonalizado = productoPersonalizadoOptional.get();
			
			Long productoBaseId = productoPersonalizado.getProductoBaseId();
			Long posiblePersonalizacionId = personalizacion.getPosiblePersonalizacionId();
			
			DTOPosiblePersonalizacion posiblePersonalizacion = proxy.chequearPosiblePersonalizacion(productoBaseId,posiblePersonalizacionId);
			
			if(posiblePersonalizacion.getAreaDePersonalizacion().contains("no existe")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(posiblePersonalizacion.getAreaDePersonalizacion());
			} else {
				
				productoPersonalizado.agregarPersonalizacion(personalizacion);
				
				return ResponseEntity.status(HttpStatus.OK).body(personalizacion);
			}
		}
	}
}
