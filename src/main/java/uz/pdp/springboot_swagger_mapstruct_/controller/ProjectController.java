package uz.pdp.springboot_swagger_mapstruct_.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.springboot_swagger_mapstruct_.entity.Person;
import uz.pdp.springboot_swagger_mapstruct_.entity.Project;
import uz.pdp.springboot_swagger_mapstruct_.entity.ProjectColumn;
import uz.pdp.springboot_swagger_mapstruct_.mapper.ProjectMapper;
import uz.pdp.springboot_swagger_mapstruct_.payload.ProjectDto;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectMapper projectMapper;

    @PostMapping("/toDTO")
    public ProjectDto toDTO() {
        return projectMapper.toDto(
                new Project(
                        "1",
                        "Project Alpha",
                        Path.of("D:\\Users\\salohiddinyunusov\\Springboot_Swagger_MapStruct_"),
                        List.of(
                                new ProjectColumn(1 , "To do", "Task must be done"),
                                new ProjectColumn(2, "In process", "Task is going")
                        )
                )
        );
    }
}
