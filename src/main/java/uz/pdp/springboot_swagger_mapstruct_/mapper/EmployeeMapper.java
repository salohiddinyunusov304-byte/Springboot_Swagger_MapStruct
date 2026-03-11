package uz.pdp.springboot_swagger_mapstruct_.mapper;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import uz.pdp.springboot_swagger_mapstruct_.entity.Employee;

import java.util.Map;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @MapMapping(keyTargetType = String.class, valueTargetType = String.class)
    Employee toEntityByMap(Map<String, String> map);

    @MapMapping(keyTargetType = String.class, valueTargetType = Object.class)
    Employee toEntityByMap2(Map<String, Object> map);

    default String fromObjectToString(Object o) {
        return String.valueOf(o);
    }
}
