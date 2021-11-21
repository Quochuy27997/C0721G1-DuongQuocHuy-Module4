package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Employee;
import com.codegym.casestudy.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
@Autowired
    IEmployeeRepository iEmployeeRepository;
    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void save(Employee Employee) {
        iEmployeeRepository.save(Employee);
    }

    @Override
    public void update(Employee Employee) {
        iEmployeeRepository.save(Employee);
    }

    @Override
    public void delete(Long id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return iEmployeeRepository.findById(id).get();
    }

    @Override
    public Page<Employee> searchAll(Pageable pageable, String name, String idPosition, String idEducationDegree, String idDivision) {
        return iEmployeeRepository.searchAll(pageable,"%"+name+"%","%"+idPosition+"%","%"+idEducationDegree+"%","%"+idDivision+"%");
    }


}
