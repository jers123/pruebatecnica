package org.javatest.assetdepreciation.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.javatest.assetdepreciation.utils.SystemConstants.ASSET_DEPRECIATION_PATH;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springshop-public")
                .pathsToMatch(ASSET_DEPRECIATION_PATH + "/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        Contact contact = new Contact();
        contact.setName("Julian Enrique Rodriguez");
        contact.setEmail("julianand2009@hotmail.com");
        contact.setUrl("https://www.linkedin.com/in/julianerodriguezs/");
        return new OpenAPI()
                .info(new Info()
                        .title("API Depresiación de activos")
                        .description("Esta es una API para poder calcular la depresiacion de los activos que se registren segun el tipo de activo.")
                        .version("1.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                        .contact(contact)
                        //.extensions()
                )
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs")
                );
    }
}