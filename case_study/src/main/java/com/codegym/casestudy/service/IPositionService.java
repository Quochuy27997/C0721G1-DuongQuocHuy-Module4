package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Division;
import com.codegym.casestudy.model.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
