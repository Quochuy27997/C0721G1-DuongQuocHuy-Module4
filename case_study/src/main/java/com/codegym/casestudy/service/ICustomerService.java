package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);
    List<Customer> findAll();
    void save(Customer Customer);
    void update(Customer Customer);
    void delete(Long id);
    Customer findById(Long id);
    Page<Customer> searchAll(Pageable pageable, String name, String idCustomerType);
}
