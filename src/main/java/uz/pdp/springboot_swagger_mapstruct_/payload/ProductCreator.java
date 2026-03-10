package uz.pdp.springboot_swagger_mapstruct_.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Schema(description = "Product yaratish uchun kerak bolgan malumotlar")
@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductCreator(
        @Schema(description = "Product nomi", example = "Laptop")
        @NotBlank(message = "Product must not be blank")
        String name,

        @Schema(description = "Product narxi", maximum = "1500", minimum = "1")
        @Positive
        Integer price
) {
}
