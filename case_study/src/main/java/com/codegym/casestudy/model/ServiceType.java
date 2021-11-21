package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity

public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "serviceType")
    private List<AppService> appServiceList;

    public ServiceType(String name, List<AppService> appServiceList) {
        this.name = name;
        this.appServiceList = appServiceList;
    }

    public ServiceType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AppService> getAppServiceList() {
        return appServiceList;
    }

    public void setAppServiceList(List<AppService> appServiceList) {
        this.appServiceList = appServiceList;
    }
}
