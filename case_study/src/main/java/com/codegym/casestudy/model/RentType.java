package com.codegym.casestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity

public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double cost;
    @OneToMany(mappedBy = "rentType")
    private List<AppService> appServiceList;

    public RentType() {
    }

    public RentType(String name, double cost, List<AppService> appServiceList) {
        this.name = name;
        this.cost = cost;
        this.appServiceList = appServiceList;
    }

    public RentType(Long id, String name, double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
    }

    public RentType(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public List<AppService> getAppServiceList() {
        return appServiceList;
    }

    public void setAppServiceList(List<AppService> appServiceList) {
        this.appServiceList = appServiceList;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
