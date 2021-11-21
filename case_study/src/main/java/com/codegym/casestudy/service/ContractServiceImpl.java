package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Contract;
import com.codegym.casestudy.repository.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ContractServiceImpl implements IContractService {
    @Autowired
    IContractRepository iContractRepository;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public void save(Contract Contract) {
        iContractRepository.save(Contract);
    }
}
