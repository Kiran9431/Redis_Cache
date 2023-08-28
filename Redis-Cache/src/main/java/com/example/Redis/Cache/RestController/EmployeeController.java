package com.example.Redis.Cache.RestController;

import com.example.Redis.Cache.Binding.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class EmployeeController {

    private HashOperations<String,Integer,Object>opsForHash = null;

    public EmployeeController(RedisTemplate<String, Employee> reditem){
        this.opsForHash =  reditem.opsForHash();

    }
    @PostMapping("/employee")
    public String addEmployee(@RequestBody Employee employee){
        opsForHash.put("EMPLOYEES", employee.getSno(),employee);
        return "Employee Added";
    }

    @GetMapping("/employees")
    public Collection<Object> getEmployees(@RequestBody Employee employee){
        Map<Integer,Object> entries = opsForHash.entries("employees");
        Collection<Object> values = entries.values();
        return values;
    }
}
