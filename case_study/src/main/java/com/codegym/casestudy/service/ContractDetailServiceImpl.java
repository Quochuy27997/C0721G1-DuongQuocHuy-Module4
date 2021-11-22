package com.codegym.casestudy.service;

import com.codegym.casestudy.model.ContractDetail;
import com.codegym.casestudy.repository.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailServiceImpl implements IContractDetailService{
    @Autowired
    IContractDetailRepository iContractDetailRepository;
    @Override
    public Page<ContractDetail> findAll(Pageable pageable) {
        return iContractDetailRepository.findAll(pageable);
    }

    @Override
    public List<ContractDetail> findAll() {
        return iContractDetailRepository.findAll();
    }

    @Override
    public void save(ContractDetail ContractDetail) {
        iContractDetailRepository.save(ContractDetail);
    }
}
