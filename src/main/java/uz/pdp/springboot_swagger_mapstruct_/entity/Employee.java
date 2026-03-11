package uz.pdp.springboot_swagger_mapstruct_.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String age;
}
