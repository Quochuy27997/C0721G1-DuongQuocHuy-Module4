package com.codegym.casestudy.service;

import com.codegym.casestudy.model.AttachService;
import com.codegym.casestudy.repository.IAttachServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttachServiceServiceImpl implements IAttachServiceService{
    @Autowired
    IAttachServiceRepository iAttachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return iAttachServiceRepository.findAll();
    }
}
