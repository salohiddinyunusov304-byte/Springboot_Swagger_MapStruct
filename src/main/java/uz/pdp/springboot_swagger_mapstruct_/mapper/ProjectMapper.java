package uz.pdp.springboot_swagger_mapstruct_.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import uz.pdp.springboot_swagger_mapstruct_.entity.Project;
import uz.pdp.springboot_swagger_mapstruct_.payload.*;

import java.nio.file.Path;

@Mapper(componentModel = "spring", uses = {ProjectColumnMapper.class}) // uses - pc_name nastroykasi uchun
public interface ProjectMapper {

    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd.MM.YYYY")
    @Mapping(target = "path", source = "path", qualifiedByName = "pathToString") // tylari har-xil bolsa, qualified iwlatsam @Named wart
    ProjectDto toDto(Project project);

    @Named("pathToString")
    default String pathToString(Path path) {
        if (path == null) {
            return null;
        }
        return path.toString();
    }
}
