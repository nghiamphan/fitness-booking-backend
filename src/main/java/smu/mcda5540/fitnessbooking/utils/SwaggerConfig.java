package smu.mcda5540.fitnessbooking.utils;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi controllerApi() {
        return GroupedOpenApi.builder().group("controller-api").packagesToScan("smu.mcda5540.fitnessbooking.controller") // Specify the package to scan
                .build();
    }
}
