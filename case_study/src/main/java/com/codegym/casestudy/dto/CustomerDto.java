package com.codegym.casestudy.dto;

import com.codegym.casestudy.model.Contract;
import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.util.List;

public class CustomerDto implements Validator {
    private Long id;
    @Pattern(regexp = "^[K][H][-]\\d{4}", message = "Please enter the correct format for customer code 'KH-XXXX' !")
    private String code;
    private String name;
    private String birthDate;
    private int gender;
    @Pattern(regexp = "\\d{9}", message = "Please enter again, id card is 9-digit string !")
    private String idCard;
    @Pattern(regexp = "\\d{10}", message = "Please enter again, number phone is 10-digit string !")
    private String phone;
    @Pattern(regexp = "^[A-z]{1}((\\w)*[.]?(\\w)*|(\\w)*[-]?(\\w)*)@[a-z0-9]+([.][a-z]{2,3}){1,5}", message = "Wrong email format (xxx@xxxx.com), please enter again !")
    private String email;
    private String address;
    private CustomerType customerType;

    private List<Customer> customerList;
    private List<Contract> contractList;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public CustomerDto() {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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
        CustomerDto customerDTO = (CustomerDto) target;

        for (Customer customer : customerDTO.getCustomerList()) {
            if (customer.getIdCard().equals(customerDTO.getIdCard())) {
                errors.rejectValue("idCard", "sameIdCard", "ID Card is exist, please enter another ID Card !");
            }
            if (customer.getPhone().equals(customerDTO.getPhone())) {
                errors.rejectValue("phone", "samePhone", "Number Phone is exist, please enter another Number Phone !");
            }
            if (customer.getEmail().equals(customerDTO.getEmail())) {
                errors.rejectValue("email", "sameEmail", "Email is exist, please enter another Email !");
            }
            if (customer.getCode().equals(customerDTO.getCode())) {
                errors.rejectValue("code", "sameCode", "Code is exist, please enter another Code !");
            }
        }
    }
}
