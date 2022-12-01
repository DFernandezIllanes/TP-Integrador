package ecommerce.msproductosbase.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "productos-base", exported = false)
public interface RepoProductoBase extends JpaRepository<ProductoBase, Long>{
}
