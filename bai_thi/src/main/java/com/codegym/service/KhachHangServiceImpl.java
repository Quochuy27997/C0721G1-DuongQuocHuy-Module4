package com.codegym.service;

import com.codegym.model.KhachHang;
import com.codegym.repository.IKhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements IKhachHangService {
    @Autowired
    IKhachHangRepository iKhachHangRepository;

    @Override
    public List<KhachHang> findAll() {
        return iKhachHangRepository.findAll();
    }
}
