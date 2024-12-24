package com.excelr.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.excelr.model.Employees;
import com.excelr.repo.EmployeeRepo;
@Service
public class ExcelrService {
    @Autowired
    private EmployeeRepo employeerepo;
    public Employees addEmployee(Employees employee) {
        return employeerepo.save(employee);
    }
    public Employees updateEmployee(int id, Employees employeeDetails) {
        Employees employee = employeerepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employee.setName(employeeDetails.getName());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());
        return employeerepo.save(employee);
    }
    public void deleteEmployee(int id) {
        Employees employee = employeerepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeerepo.delete(employee);
    }
    public List<Employees> getAllEmployees() {
        return employeerepo.findAll();
    }
}


