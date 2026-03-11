package uz.pdp.springboot_swagger_mapstruct_.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import uz.pdp.springboot_swagger_mapstruct_.entity.DayOfWeek;
import uz.pdp.springboot_swagger_mapstruct_.payload.HaftaKunlari;

@Mapper(componentModel = "spring")
public interface EnumMapper {

    @ValueMapping(target = "MONDAY", source = "DUSHANBA")
    @ValueMapping(target = "TUESDAY", source = "SESHANBA")
    @ValueMapping(target = "WEDNESDAY", source = "CHORSHANBA")
    @ValueMapping(target = "FRIDAY", source = "JUMA")
    DayOfWeek toDayOfWeek(HaftaKunlari haftaKunlari);

    @InheritInverseConfiguration
    HaftaKunlari toHaftaKunlari(DayOfWeek dayOfWeek);
}
