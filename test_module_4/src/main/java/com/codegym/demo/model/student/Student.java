package com.codegym.demo.model.student;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nS;
    private String bD;
    private String idCard;
    private String phone;
    private String eM;
    private String aD;
    private int gender;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            joinColumns=@JoinColumn(name = "st_id"),inverseJoinColumns = @JoinColumn(name = "tc_id")
    )

    private List<Teacher> teacherList;
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnS() {
        return nS;
    }

    public void setnS(String nS) {
        this.nS = nS;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
