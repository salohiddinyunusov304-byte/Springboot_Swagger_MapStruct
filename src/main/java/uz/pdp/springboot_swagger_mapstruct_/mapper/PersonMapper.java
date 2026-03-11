package uz.pdp.springboot_swagger_mapstruct_.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.pdp.springboot_swagger_mapstruct_.entity.Person;
import uz.pdp.springboot_swagger_mapstruct_.payload.AddressDto;
import uz.pdp.springboot_swagger_mapstruct_.payload.PassportDto;
import uz.pdp.springboot_swagger_mapstruct_.payload.PersonDto;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "personAddressRegion", source = "addressDto.addressRegion")
    @Mapping(target = "personAddressCity", source = "addressDto.addressCity")
    @Mapping(target = "personAddressStreet", source = "addressDto.addressStreet")
    @Mapping(target = "personPassportSeria", source = "passportDto.passportSeria")
    @Mapping(target = "personPassportNumber", source = "passportDto.passportNumber")
    Person toEntity(PersonDto personDto, AddressDto addressDto, PassportDto passportDto);

}
