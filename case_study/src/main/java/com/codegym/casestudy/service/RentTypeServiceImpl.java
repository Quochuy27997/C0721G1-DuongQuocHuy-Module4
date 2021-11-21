package com.codegym.casestudy.service;

import com.codegym.casestudy.model.RentType;
import com.codegym.casestudy.repository.IRentTypeRepository;
import com.codegym.casestudy.repository.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentTypeServiceImpl implements IRentTypeService{
    @Autowired
    IRentTypeRepository iRentTypeRepository;
    @Override
    public Iterable<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
