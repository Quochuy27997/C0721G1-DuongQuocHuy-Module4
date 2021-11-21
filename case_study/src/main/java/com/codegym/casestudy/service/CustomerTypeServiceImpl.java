package com.codegym.casestudy.service;

import com.codegym.casestudy.model.CustomerType;
import com.codegym.casestudy.repository.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType CustomerType) {
        iCustomerTypeRepository.save(CustomerType);
    }

    @Override
    public void update(CustomerType CustomerType) {
        iCustomerTypeRepository.save(CustomerType);
    }

    @Override
    public void remove(Long id) {
        iCustomerTypeRepository.deleteById(id);
    }

    @Override
    public CustomerType findById(Long id) {
        return iCustomerTypeRepository.findById(id).get();
    }
}
