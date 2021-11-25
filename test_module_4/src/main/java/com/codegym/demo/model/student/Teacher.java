package com.codegym.demo.model.student;

import com.codegym.demo.model.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nT;
    private String bD;
    private String idCard;
    private String phone;
    private String eM;
    private String aD;
    private int gender;
    @ManyToMany(mappedBy = "teacherList")
    private List<Student> studentList;

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnT() {
        return nT;
    }

    public void setnT(String nT) {
        this.nT = nT;
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

    public String getaD() {
        return aD;
    }

    public void setaD(String aD) {
        this.aD = aD;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
