package uz.pdp.springboot_swagger_mapstruct_.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_swagger_mapstruct_.entity.DayOfWeek;
import uz.pdp.springboot_swagger_mapstruct_.entity.Employee;
import uz.pdp.springboot_swagger_mapstruct_.mapper.EnumMapper;
import uz.pdp.springboot_swagger_mapstruct_.payload.HaftaKunlari;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EnumMapper enumMapper;

    @PostMapping("/toDayOfWeek")
    public DayOfWeek toDayOfWeek() {
        return enumMapper.toDayOfWeek(HaftaKunlari.DUSHANBA);
    }

    @PostMapping("/toHaftaKunlari")
    public HaftaKunlari toHaftaKunlari() {
        return enumMapper.toHaftaKunlari(DayOfWeek.WEDNESDAY);
    }
}
