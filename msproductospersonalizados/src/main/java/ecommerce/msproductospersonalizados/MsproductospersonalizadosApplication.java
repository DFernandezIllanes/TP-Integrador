package ecommerce.msproductospersonalizados;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ecommerce.msproductospersonalizados.domain.Personalizacion;
import ecommerce.msproductospersonalizados.domain.ProductoPersonalizado;
import ecommerce.msproductospersonalizados.domain.RepoVendedor;
import ecommerce.msproductospersonalizados.domain.Tienda;
import ecommerce.msproductospersonalizados.domain.Vendedor;

@SpringBootApplication
@EnableFeignClients
public class MsproductospersonalizadosApplication {
	
	@Autowired
	RepositoryRestConfiguration config;

	public static void main(String[] args) {
		SpringApplication.run(MsproductospersonalizadosApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(RepoVendedor repoVendedor) {
		
		config.exposeIdsFor(Vendedor.class, ProductoPersonalizado.class, Personalizacion.class, Tienda.class);
		
		return (cosas) -> {
			
			Vendedor vendedor1 = new Vendedor("Romeo", "Santos");
			Vendedor vendedor2 = new Vendedor("Daddy", "Yankee");
			
			repoVendedor.save(vendedor1);
			repoVendedor.save(vendedor2);
			
		};
	}

}
