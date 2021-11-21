package com.codegym.casestudy.service;

import com.codegym.casestudy.model.AppService;
import com.codegym.casestudy.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IAppServiceService {
    Page<AppService> findAll(Pageable pageable);
    List<AppService> findAll();
    void save(AppService AppService);
}
