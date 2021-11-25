package com.codegym.demo.model.st;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nC;
    private String bD;
    private String idCard;
    private String phone;
    private String eM;

    private int gender;
    @ManyToOne
    @JoinColumn(name = "adress_id", referencedColumnName = "id")
    private Adress adress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnC() {
        return nC;
    }

    public void setnC(String nC) {
        this.nC = nC;
    }

    public String getbD() {
        return bD;
    }

    public void setbD(String bD) {
        this.bD = bD;
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

    public String geteM() {
        return eM;
    }

    public void seteM(String eM) {
        this.eM = eM;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Customer() {
    }
}
