package com.codegym.casestudy.service;

import com.codegym.casestudy.model.EducationDegree;
import com.codegym.casestudy.repository.IEducationDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EducationDegreeServiceImpl implements IEducationDegreeService{
    @Autowired
    IEducationDegreeRepository iEducationDegreeRepository;
    @Override
    public List<EducationDegree> findAll() {
        return iEducationDegreeRepository.findAll();
    }
}
