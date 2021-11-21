package com.codegym.casestudy.service;

import com.codegym.casestudy.model.AppService;
import com.codegym.casestudy.repository.IAppServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceServiceImpl implements IAppServiceService {
@Autowired
    IAppServiceRepository iAppServiceRepository;
    @Override
    public Page<AppService> findAll(Pageable pageable) {
        return iAppServiceRepository.findAll(pageable);
    }

    @Override
    public List<AppService> findAll() {
        return iAppServiceRepository.findAll();
    }

    @Override
    public void save(AppService AppService) {
        iAppServiceRepository.save(AppService);
    }
}
