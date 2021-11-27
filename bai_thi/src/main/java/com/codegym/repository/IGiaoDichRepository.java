package com.codegym.repository;

import com.codegym.model.GiaoDich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGiaoDichRepository extends JpaRepository<GiaoDich,Long> {
    Page<GiaoDich> searchAll(Pageable pageable, String code, String xuatXuId, String status);
}
