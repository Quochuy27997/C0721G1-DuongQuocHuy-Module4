package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
}
