package com.sofca.historiaca;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Veterinaria",
				version = "1.0",
				description = "Prueba tecnica de Softcaribbean"
		),
		tags = {
				@Tag(name="dueno-controller", description = "Este controlador permite interactuar con la informacion de los dueños"),
				@Tag(name="ubicacion-controller", description = "Este controlador permite interactuar con la informacion de las ubicaciones"),
				@Tag(name="tipo-identificacion-controller", description = "Este controlador permite interactuar con la informacion de tipos de identificacion"),
				@Tag(name="paciente-controller", description = "Este controlador permite interactuar con la informacion de los pacientes registrados"),
				@Tag(name="mascota-controller", description = "Este controlador permite interactuar con la informacion de las mascotas registradas")
		}
)
public class HistoriacaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoriacaApplication.class, args);
	}

}
