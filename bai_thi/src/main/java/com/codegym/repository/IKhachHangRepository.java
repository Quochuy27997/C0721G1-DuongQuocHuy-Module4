package com.codegym.repository;

import com.codegym.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IKhachHangRepository extends JpaRepository<KhachHang, Long> {
}
