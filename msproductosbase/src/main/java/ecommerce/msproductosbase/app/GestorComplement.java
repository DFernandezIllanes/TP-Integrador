package ecommerce.msproductosbase.app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.msproductosbase.app.dtos.DTOPosiblePersonalizacion;
import ecommerce.msproductosbase.app.dtos.DTOProductoBase;

@RestController
public class GestorComplement {
	
	@Autowired
	RepoProductoBase repoProductoBase;
	
	@Autowired
	RepoPosiblePersonalizacion repoPosiblePersonalizacion;
	
	@GetMapping("/productos/{productoBaseId}")
	public DTOProductoBase chequearProductoBase(@PathVariable("productoBaseId") Long productoBaseId) {
		
		Optional<ProductoBase> productoBaseOptional = repoProductoBase.findById(productoBaseId);		
		
		if(productoBaseOptional.isPresent()) {
			
			ProductoBase productoBase = productoBaseOptional.get();			
			return productoBase.toDTOProductoBase();
		
		} else {
			
			return new DTOProductoBase("no existe");
		}
	}
	
	@GetMapping("/productos/{productoBaseId}/personalizaciones/{posiblePersonalizacionId}")
	public DTOPosiblePersonalizacion chequearPosiblePersonalizacion(
			@PathVariable("productoBaseId") Long productoBaseId,
			@PathVariable("posiblePersonalizacionId") Long posiblePersonalizacionId) {
		
		Optional<ProductoBase> productoBaseOptional = repoProductoBase.findById(productoBaseId);
		Optional<PosiblePersonalizacion> posiblePersonalizacionOptional = repoPosiblePersonalizacion.findById(posiblePersonalizacionId);
		
		if(productoBaseOptional.isPresent() && posiblePersonalizacionOptional.isPresent()) {
			
			ProductoBase productoBase = productoBaseOptional.get();
			PosiblePersonalizacion posiblePersonalizacion = posiblePersonalizacionOptional.get();
			
			if(posiblePersonalizacion.getProductoBase().getId() != productoBase.getId()) {
				return new DTOPosiblePersonalizacion("no existe esa posible personalizacion para el producto base");
			} else {
				return posiblePersonalizacion.toDTOPosiblePersonalizacion();
			}		
			
		} else {
			
			return new DTOPosiblePersonalizacion("no existe el producto base o la posible personalizacion");
		}
		
	}

}
