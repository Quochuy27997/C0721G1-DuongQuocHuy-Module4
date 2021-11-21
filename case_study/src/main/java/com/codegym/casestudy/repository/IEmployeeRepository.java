package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value="select * from employee where name like :name and position like :id and education_degree like : id and division like : id" ,nativeQuery=true)
    Page<Employee> searchAll(Pageable pageable, @Param("name") String name, @Param("id") String position,@Param("id") String educationDegree,@Param("id") String division);
}
