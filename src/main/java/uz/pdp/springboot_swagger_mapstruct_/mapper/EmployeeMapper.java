package uz.pdp.springboot_swagger_mapstruct_.mapper;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import uz.pdp.springboot_swagger_mapstruct_.entity.Employee;

import java.util.Map;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    default Employee toEntityByMap(Map<String, String> map) {
        Employee employee = new Employee();
        employee.setFirstName(fromObjectToString(map.get("firstName")));
        employee.setLastName(fromObjectToString(map.get("lastName")));
        employee.setAge(fromObjectToString(map.get("age")));
        return employee;
    }

    @MapMapping(keyTargetType = String.class, valueTargetType = Object.class)
    Employee toEntityByMap2(Map<String, Object> map);

    default String fromObjectToString(Object o) {
        return String.valueOf(o);
    }
}
