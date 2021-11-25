package com.codegym.casestudy.dto;


import com.codegym.casestudy.model.AppService;
import com.codegym.casestudy.model.Contract;
import com.codegym.casestudy.model.RentType;
import com.codegym.casestudy.model.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class AppServiceDto implements Validator {

    private Long id;
    @Pattern(regexp = "^[D][V][-]\\d{4}", message = "Please enter the correct format for customer code 'DV-XXXX' !")
    private String code;
    @NotBlank(message = "Service Name cannot be blank or empty!")
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private RentType rentType;
    private ServiceType serviceType;
    @NotBlank(message = "Standard Room cannot be blank or empty!")
    private String roomStandard;
    private String convenient;
    private double poolArea;
    @Min(value = 1, message = "Number of floor must be more than 1 !")
    private int numberOfFloors;
    private List<Contract> contractList;
    private List<AppService> appServiceList;

    public List<AppService> getAppServiceList() {
        return appServiceList;
    }

    public void setAppServiceList(List<AppService> appServiceList) {
        this.appServiceList = appServiceList;
    }

    public AppServiceDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
