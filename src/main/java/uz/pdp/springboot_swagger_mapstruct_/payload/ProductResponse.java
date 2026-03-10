package uz.pdp.springboot_swagger_mapstruct_.payload;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductResponse(
        Integer id,
        String name,
        Integer price
) {
}
