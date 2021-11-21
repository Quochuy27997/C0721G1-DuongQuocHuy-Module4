package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);
    List<Employee> findAll();
    void save(Employee Employee);
    void update(Employee Employee);
    void delete(Long id);
    Employee findById(Long id);
    Page<Employee> searchAll(Pageable pageable, String name, String idPosition,String idEducationDegree,String idDivision);
}
