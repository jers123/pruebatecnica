package org.javatest.assetdepreciation.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springdoc.core.models.GroupedOpenApi;

import static org.javatest.assetdepreciation.utils.SystemConstants.ASSET_DEPRECIATION_PATH;
import static org.junit.jupiter.api.Assertions.*;

class SwaggerConfigTest {

    private SwaggerConfig config;

    @BeforeEach
    void setup() {
        config = new SwaggerConfig();
    }

    @Test
    public void testPublicApi() {
        GroupedOpenApi publicApi = config.publicApi();

        assertEquals("springshop-public", publicApi.getGroup());
        assertEquals(ASSET_DEPRECIATION_PATH + "/**", publicApi.getPathsToMatch().get(0));
    }

    @Test
    public void testSpringShopOpenAPI() {
        OpenAPI openApi = config.springShopOpenAPI();

        Info info = openApi.getInfo();
        Contact contact = info.getContact();
        ExternalDocumentation externalDocs = openApi.getExternalDocs();

        assertEquals("API Depresiación de activos", info.getTitle());
        assertEquals("Esta es una API para poder calcular la depresiacion de los activos que se registren segun el tipo de activo.", info.getDescription());
        assertEquals("1.0", info.getVersion());
        assertEquals("Apache 2.0", info.getLicense().getName());

        assertEquals("Julian Enrique Rodriguez", contact.getName());
        assertEquals("julianand2009@hotmail.com", contact.getEmail());
        assertEquals("https://www.linkedin.com/in/julianerodriguezs/", contact.getUrl());

        assertEquals("SpringShop Wiki Documentation", externalDocs.getDescription());
        assertEquals("https://springshop.wiki.github.org/docs", externalDocs.getUrl());
    }

    @AfterEach
    void tearDown() {
        config = null;
    }
}