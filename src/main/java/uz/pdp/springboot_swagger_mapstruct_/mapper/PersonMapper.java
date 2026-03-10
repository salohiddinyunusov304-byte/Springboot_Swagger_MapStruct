package uz.pdp.springboot_swagger_mapstruct_.mapper;

import org.mapstruct.Mapper;
import uz.pdp.springboot_swagger_mapstruct_.entity.Person;
import uz.pdp.springboot_swagger_mapstruct_.payload.AddressDto;
import uz.pdp.springboot_swagger_mapstruct_.payload.PassportDto;
import uz.pdp.springboot_swagger_mapstruct_.payload.PersonDto;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    Person toEntity(PersonDto personDto, AddressDto addressDto, PassportDto passportDto);

    PersonDto toDto(Person person);
}
