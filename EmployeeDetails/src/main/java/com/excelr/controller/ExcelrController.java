package com.excelr.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.excelr.model.Employees;
import com.excelr.service.ExcelrService;
@RestController
@RequestMapping("/dinesh/employees")
public class ExcelrController {
	@Autowired
    private ExcelrService service;
    @PostMapping
    public Employees addEmployee(@RequestBody Employees employee) {
        return service.addEmployee(employee);
    }
    @PutMapping("/{id}")
    public Employees updateEmployee(@PathVariable int id, @RequestBody Employees employee) {
        return service.updateEmployee(id, employee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
    	service.deleteEmployee(id);
    }
    @GetMapping
    public List<Employees> getAllEmployees() {
        return service.getAllEmployees();
    }
}


