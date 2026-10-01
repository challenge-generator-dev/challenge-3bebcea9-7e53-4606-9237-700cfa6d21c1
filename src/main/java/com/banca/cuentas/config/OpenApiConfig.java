package com.banca.cuentas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Cuentas Bancarias")
                        .version("1.0.0")
                        .description("""
                                API REST para la gestión de cuentas bancarias.
                                
                                Permite realizar operaciones CRUD sobre cuentas,
                                incluyendo creación, consulta, actualización y eliminación.
                                """)
                        .contact(new Contact()
                                .name("Equipo de Desarrollo")
                                .email("desarrollo@banca.com")
                                .url("https://www.banca.com"))
                        .license(new License()
                                .name("Licencia Proprietaria")
                                .url("https://www.banca.com/licencia")))
                .addTagsItem(new io.swagger.v3.oas.models.tags.Tag()
                        .name("Cuentas")
                        .description("Operaciones sobre cuentas bancarias"));
    }
}