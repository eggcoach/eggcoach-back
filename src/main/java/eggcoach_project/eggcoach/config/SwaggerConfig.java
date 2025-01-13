package eggcoach_project.eggcoach.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI EggCoachOpenAPI() {

        Info info = new Info()
                .title("EggCoach API")
                .version("1.0.0")
                .description("EggCoach API");

        return new OpenAPI()
                .info(info)
                .addServersItem(new Server().url("/"));
    }
}
