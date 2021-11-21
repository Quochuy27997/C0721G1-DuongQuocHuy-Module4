
package com.codegym.casestudy.model;


import javax.persistence.*;
import java.util.List;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    @Column(columnDefinition = "Date")
    private String birthDate;
    private String idCard;
    private double salary;
    private String phone;
    private String email;
    private String address;
    @ManyToOne(targetEntity = Position.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    @ManyToOne(targetEntity = EducationDegree.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "educationDegree", referencedColumnName = "id")
    private EducationDegree educationDegree;
    @ManyToOne(targetEntity = Division.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "division", referencedColumnName = "id")
    private Division division;

    @OneToMany(mappedBy = "employee")
    private List<Contract> contractList;

    public Employee(String code, String birthDate, String name, String idCard, double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division) {
        this.code = code;
        this.birthDate = birthDate;
        this.name = name;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;

    }

    public Employee(String code, String name, String birthDate, String idCard, double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, List<Contract> contractList) {
        this.code = code;
        this.name = name;
        this.birthDate = birthDate;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.contractList = contractList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public Employee() {
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }



    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }


}