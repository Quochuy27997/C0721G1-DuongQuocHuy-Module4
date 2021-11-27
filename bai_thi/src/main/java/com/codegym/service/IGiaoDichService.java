package com.codegym.service;

import com.codegym.model.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IGiaoDichService {
    Page<GiaoDich> findAll(Pageable pageable);

    List<GiaoDich> findAll();

    void save(GiaoDich giaoDich);

    void update(GiaoDich giaoDich);

    void delete(Long id);

    GiaoDich findById(Long id);

    Page<GiaoDich> searchAll(Pageable pageable, String code, String xuatXuId, String status);
}
