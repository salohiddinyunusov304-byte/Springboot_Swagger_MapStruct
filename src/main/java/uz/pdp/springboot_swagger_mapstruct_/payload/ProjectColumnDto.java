package uz.pdp.springboot_swagger_mapstruct_.payload;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProjectColumnDto {
    private Integer id;
    private String pc_name;
    private String description;
    private String createdAt ;
}
