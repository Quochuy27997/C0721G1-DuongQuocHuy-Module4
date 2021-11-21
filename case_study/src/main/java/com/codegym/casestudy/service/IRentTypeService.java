package com.codegym.casestudy.service;

import com.codegym.casestudy.model.RentType;

public interface IRentTypeService {
    Iterable<RentType> findAll();
}
