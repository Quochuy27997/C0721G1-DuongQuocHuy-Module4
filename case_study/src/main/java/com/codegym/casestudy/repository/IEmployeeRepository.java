package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    @Query(value="select * from employee where `name` like :name and position_id like :position_id and education_degree" +
            " like :education_degree_id " +
            "and division like :division_id" ,nativeQuery=true)
    Page<Employee> searchAll(Pageable pageable, @Param("name") String name, @Param("position_id") String position,
                             @Param("education_degree_id") String educationDegree,@Param("division_id") String division);
}
