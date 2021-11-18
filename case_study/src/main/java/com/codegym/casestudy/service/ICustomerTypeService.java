package com.codegym.casestudy.service;

import com.codegym.casestudy.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
    void save(CustomerType CustomerType);
    void update(CustomerType CustomerType);
    void remove(Long id);
    CustomerType findById(Long id);
}
