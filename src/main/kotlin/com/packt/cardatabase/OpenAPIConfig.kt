package com.packt.cardatabase

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import jakarta.servlet.ServletContext
import org.springframework.context.annotation.Configuration

@Configuration
class OpenAPIConfig {
    fun carDatabaseOpenAPI(servletContext: ServletContext): OpenAPI {
        val server = Server().url(servletContext.contextPath)
        return OpenAPI()
            .info(Info().title("Car REST API").description("My car stock").version("1.0"))
            .servers(listOf(server))
    } 
}