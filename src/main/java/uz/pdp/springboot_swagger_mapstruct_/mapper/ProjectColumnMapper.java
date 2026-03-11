package uz.pdp.springboot_swagger_mapstruct_.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.pdp.springboot_swagger_mapstruct_.entity.ProjectColumn;
import uz.pdp.springboot_swagger_mapstruct_.payload.ProjectColumnDto;

@Mapper(componentModel = "spring")
public interface ProjectColumnMapper {

    @Mapping(target = "pc_name", source = "name")
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd.MM.YYYY")
    ProjectColumnDto toDto(ProjectColumn projectColumn);

}
