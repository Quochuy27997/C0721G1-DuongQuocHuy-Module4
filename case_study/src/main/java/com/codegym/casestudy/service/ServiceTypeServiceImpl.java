package com.codegym.casestudy.service;

import com.codegym.casestudy.model.ServiceType;
import com.codegym.casestudy.repository.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeServiceImpl implements IServiceTypeService{
    @Autowired
    IServiceTypeRepository iServiceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return iServiceTypeRepository.findAll();
    }
}
