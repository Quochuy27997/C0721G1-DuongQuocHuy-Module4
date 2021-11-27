package com.codegym.service;

import com.codegym.model.GiaoDich;
import com.codegym.repository.IGiaoDichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GiaoDichServiceImpl implements IGiaoDichService {
    @Autowired
    IGiaoDichRepository iGiaoDichRepository;
    @Override
    public Page<GiaoDich> findAll(Pageable pageable) {
        return iGiaoDichRepository.findAll(pageable);
    }

    @Override
    public List<GiaoDich> findAll() {
        return iGiaoDichRepository.findAll();
    }

    @Override
    public void save(GiaoDich giaoDich) {
        iGiaoDichRepository.save(giaoDich);
    }

    @Override
    public void update(GiaoDich giaoDich) {
        iGiaoDichRepository.save(giaoDich);
    }

    @Override
    public void delete(Long id) {
        iGiaoDichRepository.deleteById(id);
    }

    @Override
    public GiaoDich findById(Long id) {
        return iGiaoDichRepository.findById(id).get();
    }

    @Override
    public Page<GiaoDich> searchAll(Pageable pageable, String code, String xuatXuId, String status) {
        return iGiaoDichRepository.searchAll(pageable,code,xuatXuId,status);
    }
}
