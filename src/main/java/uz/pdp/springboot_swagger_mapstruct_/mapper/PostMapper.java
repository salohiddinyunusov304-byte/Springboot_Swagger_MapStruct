package uz.pdp.springboot_swagger_mapstruct_.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import uz.pdp.springboot_swagger_mapstruct_.entity.Post;
import uz.pdp.springboot_swagger_mapstruct_.payload.PostDto;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "p_title", source = "title")
    @Mapping(target = "p_content", source = "content")
    @Mapping(target = "order", ignore = true)
//    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
    @Mapping(target = "id", expression = "java(generateId())")
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = "dd.MM.YYYY")
    Post toEntity(PostDto postDto);

    default String generateId() {
        return UUID.randomUUID().toString();
    }

    /* @Mapping(target = "title", source = "p_title")
     @Mapping(target = "content", source = "p_content")*/
    @InheritInverseConfiguration
    PostDto toDto(Post post);
}
