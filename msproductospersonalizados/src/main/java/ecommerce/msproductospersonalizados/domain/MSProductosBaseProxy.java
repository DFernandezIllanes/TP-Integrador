package ecommerce.msproductospersonalizados.domain;


import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ecommerce.msproductospersonalizados.domain.dtos.DTOPosiblePersonalizacion;
import ecommerce.msproductospersonalizados.domain.dtos.DTOProductoBase;


@FeignClient(name = "msproductosbase")
public interface MSProductosBaseProxy {
	
//	@GetMapping("/gestores/{gestorId}/productos-base/{productoBaseId}")
//	public DTOProductoBase buscarProductoBase(
//			@PathVariable("gestorId") String gestorId,
//			@PathVariable("productoBaseId") String productoBaseId);
	@GetMapping("/productos/{productoBaseId}")
	public DTOProductoBase chequearProductoBase(@PathVariable("productoBaseId") Long productoBaseId);
	
	@GetMapping("/productos/{productoBaseId}/personalizaciones/{posiblePersonalizacionId}")
	public DTOPosiblePersonalizacion chequearPosiblePersonalizacion(
			@PathVariable("productoBaseId") Long productoBaseId,
			@PathVariable("posiblePersonalizacionId") Long posiblePersonalizacionId);

}
