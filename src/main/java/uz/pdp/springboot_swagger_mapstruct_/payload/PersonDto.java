package uz.pdp.springboot_swagger_mapstruct_.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonDto {
    private String name;
    private Integer age;
}
