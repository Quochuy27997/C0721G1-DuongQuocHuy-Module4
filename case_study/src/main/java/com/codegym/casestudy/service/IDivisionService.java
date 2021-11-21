package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Division;
import com.codegym.casestudy.model.ServiceType;

import java.util.List;

public interface IDivisionService {
    List<Division> findAll();
}
