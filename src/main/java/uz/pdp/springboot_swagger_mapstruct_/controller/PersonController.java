package uz.pdp.springboot_swagger_mapstruct_.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_swagger_mapstruct_.entity.Person;
import uz.pdp.springboot_swagger_mapstruct_.mapper.PersonMapper;
import uz.pdp.springboot_swagger_mapstruct_.payload.AddressDto;
import uz.pdp.springboot_swagger_mapstruct_.payload.PassportDto;
import uz.pdp.springboot_swagger_mapstruct_.payload.PersonDto;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonMapper personMapper;

    @GetMapping("/toEntity")
    public Person toEntity() {
        return personMapper.toEntity(
                new PersonDto("John Doue", 30),
                new AddressDto("Tashkent", "Mirabad", "Afrosiyob street"),
                new PassportDto("AC", "2040614")
        );
    }
}
