package ecommerce.msproductosbase.app;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ecommerce.msproductosbase.app.dtos.DTOProductoBase;

@RepositoryRestController
public class GestorControllerComplement {
	
	@Autowired
	RepoGestor repoGestor;
	
	@Autowired
	RepoProductoBase repoProducto;
	
	//------------- Métodos de Productos Base ---------------------------------
	
//	@GetMapping("/materia/{matId}/correlativas/{aprobadas}")
//    public RtaCorrDTO chequearCorrelativa(@PathVariable("matId") String matId,
//                                      @PathVariable("aprobadas") String aprobadas) {
//        if(matId.equals("14")) {
//            return new RtaCorrDTO("Ok", "tiene todo - " + puerto);
//        } else {
//            return new RtaCorrDTO("no", "porque no - " + puerto);
//        }
//    }
	
//	@GetMapping("/gestores/{gestorId}/productos/{productoBaseId}")
//	public String chequearProductoBase(@PathVariable("gestorId") String gestorId,
//                                    @PathVariable("productoBaseId") String productoBaseId) {
//		if(gestorId.equals("14")) {
//			return "Es igual";
//			} else {
//			return "No es igual";
//		}
//	}
	
//	@GetMapping("/gestores/{gestorId}/productos-base/{productoBaseId}")
//	public DTOProductoBase buscarProductoBase(
//			@PathVariable("gestorId") String gestorId,
//			@PathVariable("productoBaseId") String productoBaseId) {		
//		
//		Optional<ProductoBase> productoBaseOptional = repoProducto.findById(Long.valueOf(productoBaseId));
//		
//		if(productoBaseOptional.isEmpty()) {
//			return new DTOProductoBase();
//		} else {
//			ProductoBase productoBase = productoBaseOptional.get();
//			return productoBase.toDTOProductoBase();
//		}
//		
//	}
	
//	@GetMapping("/gestores/{gestorId}/productos-base/{productoBaseId}")
//	public @ResponseBody ResponseEntity<Object> findProductoBaseById(
//			@PathVariable("gestorId") Long gestorId,
//			@PathVariable("productoBaseId") Long productoBaseId) {
//		
//		Optional<Gestor> gestorOptional = repoGestor.findById(gestorId);
//		Optional<ProductoBase> productoOptional = repoProducto.findById(productoBaseId);
//		
//		if(gestorOptional.isEmpty() || productoOptional.isEmpty()) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Gestor o Producto Base inexistentes");
//		} else {
//			Gestor gestor = gestorOptional.get();
//			ProductoBase productoBase = productoOptional.get();
//			
//			if(productoBase.getGestor().getId() != gestor.getId()) {
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos ingresados inconsistentes");
//			} else {
//				return ResponseEntity.status(HttpStatus.OK).body(productoBase);
//			}
//		}
//		
//	}
	
	@Transactional
	@PostMapping("/gestores/{gestorId}/productos-base")
	public @ResponseBody ResponseEntity<Object> crearProductoBase(
			@PathVariable("gestorId") Long gestorId,
			@RequestBody(required = true) ProductoBase producto) {
		
		Optional<Gestor> gestorOptional = repoGestor.findById(gestorId);
		
		if(!gestorOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el gestor");
		} else {
			Gestor gestor = gestorOptional.get();
			
			if(producto == null || producto.equals("")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos del producto inválidos");
			} else {
				gestor.agregarProductoBase(producto);
				
				return ResponseEntity.status(HttpStatus.OK).body(producto);
			}
		}		
	}
	
	@Transactional
	@PutMapping("/gestores/{gestorId}/productos-base/{productoBaseId}")
	public @ResponseBody ResponseEntity<Object> actualizarProductoBase(
			@PathVariable("gestorId") Long gestorId,
			@PathVariable("productoBaseId") Long productoBaseId,
			@RequestBody(required = true) ProductoBase producto) {
		
		Optional<Gestor> gestorOptional = repoGestor.findById(gestorId);
		Optional<ProductoBase> productoOptional = repoProducto.findById(productoBaseId);
		
		if(!gestorOptional.isPresent() || !productoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El gestor o el producto base no existe");
		} else {
			Gestor gestor = gestorOptional.get();
			ProductoBase productoBase = productoOptional.get();
			
			if(producto == null || producto.equals("")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos del producto inválidos");
			} else {
				producto.setGestor(gestor);
				producto.setId(productoBaseId);
				
				productoBase = producto;
				
				//return ResponseEntity.status(HttpStatus.OK).body("Producto Base actualizado");
				return ResponseEntity.status(HttpStatus.OK).body(productoBase);
				
			}
		}		
	}
	
	//-------------- Métodos de Posibles Personalizaciones ---------------------------------
	
	@Transactional
	@PostMapping("/gestores/{gestorId}/productos-base/{productoBaseId}/posibles-personalizaciones")
	public @ResponseBody ResponseEntity<Object> crearPosiblePersonalizacion(
			@PathVariable("gestorId") Long gestorId,
			@PathVariable("productoBaseId") Long productoBaseId,
			@RequestBody(required = true) PosiblePersonalizacion personalizacion) {
		
		Optional<Gestor> gestorOptional = repoGestor.findById(gestorId);
		Optional<ProductoBase> productoOptional = repoProducto.findById(productoBaseId);
		
		if(gestorOptional.isEmpty() || productoOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe el gestor o el producto base");
		} else {
			Gestor gestor = gestorOptional.get();
			ProductoBase producto = productoOptional.get();
			
			if(personalizacion == null || personalizacion.equals("") || producto.getGestor().getId() != gestor.getId()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos de la personalización inválidos");
			} else {
				producto.agregarPosiblePersonalizacion(personalizacion);
				
				return ResponseEntity.status(HttpStatus.OK).body(personalizacion);
			}
		}		
	}

}
