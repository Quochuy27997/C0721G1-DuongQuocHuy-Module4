package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Contract;
import com.codegym.casestudy.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService {
    Page<ContractDetail> findAll(Pageable pageable);
    List<ContractDetail> findAll();
    void save(ContractDetail ContractDetail);
}
