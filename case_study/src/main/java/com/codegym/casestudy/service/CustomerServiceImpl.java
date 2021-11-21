package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
@Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer Customer) {
        iCustomerRepository.save(Customer);
    }

    @Override
    public void update(Customer Customer) {
        iCustomerRepository.save(Customer);
    }

    @Override
    public void delete(Long id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public Customer findById(Long id) {
        return iCustomerRepository.findById(id).get();
    }

    @Override
    public Page<Customer> searchAll(Pageable pageable, String name, String idCustomerType) {
        return iCustomerRepository.searchAll(pageable,"%"+name+"%","%"+idCustomerType+"%");
    }
}
