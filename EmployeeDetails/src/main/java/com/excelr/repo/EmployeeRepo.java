package com.excelr.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.excelr.model.Employees;
public interface EmployeeRepo extends JpaRepository<Employees,Integer> {

}
