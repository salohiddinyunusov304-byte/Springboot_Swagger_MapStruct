package uz.pdp.springboot_swagger_mapstruct_.payload;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AddressDto {
    private String addressRegion;
    private String addressCity;
    private String addressStreet;
}
