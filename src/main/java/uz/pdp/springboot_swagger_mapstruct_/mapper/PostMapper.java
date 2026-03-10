package uz.pdp.springboot_swagger_mapstruct_.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.pdp.springboot_swagger_mapstruct_.entity.Post;
import uz.pdp.springboot_swagger_mapstruct_.payload.PostDto;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "p_title", source = "title")
    @Mapping(target = "p_content", source = "content")
    @Mapping(target = "id", expression = "java(random())")
    Post toEntity(PostDto postDto);

//    @Mapping(target = "title", source = "p_title")
//    @Mapping(target = "content", source = "p_content")
    @InheritInverseConfiguration // shunda oldin ishlatilgan covertatsiyani teskarisini ishlatadi
    PostDto toDto(Post post);

    default String random() {
        return UUID.randomUUID().toString();
    }
}
