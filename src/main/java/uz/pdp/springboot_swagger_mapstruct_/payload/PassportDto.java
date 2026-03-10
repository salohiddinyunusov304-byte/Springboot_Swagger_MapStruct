package uz.pdp.springboot_swagger_mapstruct_.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PassportDto {
    private String passportSeria;
    private String passportNumber;
}
