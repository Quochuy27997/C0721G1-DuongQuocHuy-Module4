package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Division;
import com.codegym.casestudy.model.ServiceType;
import com.codegym.casestudy.repository.IDivisionRepository;
import com.codegym.casestudy.repository.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DivisionServiceImpl implements IDivisionService{
    @Autowired
    IDivisionRepository iDivisionRepository;
    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
