package ecommerce.msproductosbase.app;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class GestorControllerComplement {
	
	@Autowired
	RepoGestor repoGestor;
	
	@Autowired
	RepoProductoBase repoProducto;
	
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
				
				return ResponseEntity.status(HttpStatus.OK).body("Producto Base creado");
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
				return ResponseEntity.status(HttpStatus.OK).body(productoBase.getId());
				
			}
		}
		
		
	}

}
