package uz.pdp.springboot_swagger_mapstruct_.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    private String id;
    private String name;
    private Integer age;

    private String personAddressRegion;
    private String personAddressCity;
    private String personAddressStreet;

    private String personPassportSeria;
    private String personPassportNumber;
}
