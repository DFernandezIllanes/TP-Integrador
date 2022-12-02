package ecommerce.msproductospersonalizados.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "productos-personalizados")
public interface RepoProductoPersonalizado extends JpaRepository<ProductoPersonalizado, Long> {
	
	@Override
	@RestResource(exported = false)
	void deleteById(Long id);
	
	@Override
	@RestResource(exported = false)
	void delete(ProductoPersonalizado productoPersonalizado);
	
	ProductoPersonalizado findByNombre(String nombre);

}
