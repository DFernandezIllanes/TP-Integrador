package ecommerce.msproductosbase.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "productos-base")
public interface RepoProductoBase extends JpaRepository<ProductoBase, Long>{
	
	@Override
	@RestResource(exported = false)
	ProductoBase save(ProductoBase productoBase);
	
	ProductoBase findByNombre(String nombre);
}
