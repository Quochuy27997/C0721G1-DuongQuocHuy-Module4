package com.codegym.casestudy.dto;

import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;
import java.util.List;

public class CustomerDTO implements Validator {
    private Long id;
    private String code;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Wrong name format, please enter again ! ")
    private String name;
    private String birthDate;
    private int gender;
    @Pattern(regexp = "\\d{9}",message = "Please enter again, id card is 9-digit string !")
    private String idCard;
    @Pattern(regexp = "\\d{10}",message ="Please enter again, number phone is 10-digit string !" )
    private String phone;
    @Pattern(regexp = "^[A-z]{1}((\\w)*[.]?(\\w)*|(\\w)*[-]?(\\w)*)@[a-z0-9]+([.][a-z]{2,3}){1,5}",message = "Wrong email format (xxx@xxxx.com), please enter again !")
    private String email;
    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$",message = "Wrong address format, please enter again !")
    private String address;
    private CustomerType customerType;

    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerDTO() {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        List<Customer> customerList= customerDTO.getCustomers();
        Long i = customerDTO.getId();
        for (int j = 0; j < customerList.size(); j++) {
            if(customerList.get(j).getId()==i){
                customerList.remove(j);
                break;
            }

        }
        for(Customer customer:customerList){
            if(customerDTO.getIdCard().equals(customer.getIdCard())){
                errors.rejectValue("idCard","sameIdCard","ID Card is exist, please enter another ID Card !");
            }
            if(customerDTO.getEmail().equals(customer.getEmail())){
                errors.rejectValue("email","sameEmail","Email is exist, please enter another Email !");
            }
            if(customerDTO.getPhone().equals(customer.getPhone())){
                errors.rejectValue("phone","samePhone","Number Phone is exist, please enter another Number Phone !");
            }
        }
    }
}
