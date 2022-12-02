package ecommerce.msproductosbase.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "posibles-personalizaciones")
public interface RepoPosiblePersonalizacion extends JpaRepository<PosiblePersonalizacion, Long>{
	
	@Override
	@RestResource(exported = false)
	PosiblePersonalizacion save(PosiblePersonalizacion personalizacion);
	
	PosiblePersonalizacion findByAreaDePersonalizacion(String areaDePersonalizacion);
	
	PosiblePersonalizacion findByTipoDePersonalizacion(String tipoDePersonalizacion);

}
