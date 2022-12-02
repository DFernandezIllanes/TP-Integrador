package ecommerce.msproductosbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import ecommerce.msproductosbase.app.Gestor;
import ecommerce.msproductosbase.app.PosiblePersonalizacion;
import ecommerce.msproductosbase.app.ProductoBase;
import ecommerce.msproductosbase.app.RepoGestor;

@SpringBootApplication
public class MsproductosbaseApplication {
	
	@Autowired
	RepositoryRestConfiguration config;

	public static void main(String[] args) {
		SpringApplication.run(MsproductosbaseApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner init(RepoGestor repoGestor) {
		
		config.exposeIdsFor(Gestor.class, ProductoBase.class, PosiblePersonalizacion.class);
		
		return (cosas) -> {
			
			Gestor gestor1 = new Gestor("Alejandro", "Fantino");
			Gestor gestor2 = new Gestor("Sergio", "Figluolo");
			
			ProductoBase productoBase1 = new ProductoBase("remera", 1200d, "remera blanca lisa", "3 dias");
			ProductoBase productoBase2 = new ProductoBase("campera", 2400d, "campera azul base", "7 dias");
			
			PosiblePersonalizacion posiblePersonalizacion1 = new PosiblePersonalizacion("frente", "texto blanco y negro");
			PosiblePersonalizacion posiblePersonalizacion2 = new PosiblePersonalizacion("espalda", "imagen a color");
			
					
			gestor1.agregarProductoBase(productoBase1);
			gestor2.agregarProductoBase(productoBase2);
			
			productoBase1.agregarPosiblePersonalizacion(posiblePersonalizacion1);
			productoBase2.agregarPosiblePersonalizacion(posiblePersonalizacion2);
			
			repoGestor.save(gestor1);
			repoGestor.save(gestor2);
			
		};
	}

}
