package com.codegym.casestudy.repository;

import com.codegym.casestudy.model.AppService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppServiceRepository extends JpaRepository<AppService,Long> {
}
