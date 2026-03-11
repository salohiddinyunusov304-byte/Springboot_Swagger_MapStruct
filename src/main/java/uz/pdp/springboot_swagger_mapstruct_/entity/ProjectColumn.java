package uz.pdp.springboot_swagger_mapstruct_.entity;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProjectColumn {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();

    public ProjectColumn(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }
}
