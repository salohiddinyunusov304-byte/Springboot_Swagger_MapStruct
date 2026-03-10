package uz.pdp.springboot_swagger_mapstruct_;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import uz.pdp.springboot_swagger_mapstruct_.entity.Product;
import uz.pdp.springboot_swagger_mapstruct_.repository.ProductRepository;

import java.util.List;

//@OpenAPIDefinition(
//        info = @Info(
//            title = "Product API | G58 Open Specification | Swagger",
//            version = "1.0",
//            description = "API for managing product",
//            contact = @Contact(
//                     name = "Salohiddin Yunusov",
//                     email = "salohiddinyunusov377@gmail.com"
//            ),
//            license = @License(
//                    name = "MIT License",
//                    url = "https://opensource.org/licenses/MIT"
//            )
//        ),
//        servers = {
//                @Server(
//                        url = "http://localhost:8080",
//                        description = "Dev Server"
//                ),
//                @Server(
//                        url = "http://localhost:9090",
//                        description = "Test Server"
//                ),
//                @Server(
//                        url = "http://localhost:7070",
//                        description = "Prod Server"
//                )
//        }
//)
@SpringBootApplication
@RequiredArgsConstructor
public class SpringbootSwaggerMapStructApplication {
    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSwaggerMapStructApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            productRepository.saveAll(
                    List.of(
                            Product.builder()
                                    .name("Product 1")
                                    .price(100)
                                    .build(),
                            Product.builder()
                                    .name("Product 2")
                                    .price(200)
                                    .build(),
                            Product.builder()
                                    .name("Product 3")
                                    .price(300)
                                    .build()
                    )
            );
        };
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring 6 Swagger 2 Annotation Example")
                        .description("Spring 6 Swagger Simple Application")
                        .version("${api.version}")
                        .contact(new Contact()
                                .name("Salohiddin Yunusov")
                                .email("john.lgd65@gmail.com")
                                .url("https://github.com/jlkesh"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("http://swagger.io/terms/"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Production"),
                        new Server()
                                .url("http://localhost:9090")
                                .description("Test Server")
                ));
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
