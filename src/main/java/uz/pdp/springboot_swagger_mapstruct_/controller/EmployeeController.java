package uz.pdp.springboot_swagger_mapstruct_.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_swagger_mapstruct_.entity.Employee;
import uz.pdp.springboot_swagger_mapstruct_.mapper.EmployeeMapper;

import java.util.Map;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeMapper employeeMapper;

    @GetMapping("/toEntityByMap")
    public Employee toEntityByMap(@RequestBody Map<String, String> map) {
        return employeeMapper.toEntityByMap(map);
    }

    @GetMapping("/toEntityByMap2")
    public Employee toEntityByMap2(@RequestBody Map<String, Object> map) {
        return employeeMapper.toEntityByMap2(map);
    }
}
