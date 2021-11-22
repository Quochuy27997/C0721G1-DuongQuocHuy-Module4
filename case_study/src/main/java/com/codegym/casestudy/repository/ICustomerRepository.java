package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    @Query(value="select * from customer where `name` like :name and customer_type_id like :id",nativeQuery=true)
    Page<Customer> searchAll(Pageable pageable, @Param("name") String name, @Param("id") String customerTypeId);
}
