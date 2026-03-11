package uz.pdp.springboot_swagger_mapstruct_.payload;

import lombok.*;
import uz.pdp.springboot_swagger_mapstruct_.entity.ProjectColumn;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class  ProjectDto {
    private Integer id;
    private String name;
    private String path;
    private List<ProjectColumnDto> columns;
    private String createdAt;
}
