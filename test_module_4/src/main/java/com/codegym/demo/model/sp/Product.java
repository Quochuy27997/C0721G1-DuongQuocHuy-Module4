package com.codegym.demo.model.sp;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameP;
    @ManyToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    private Cate cate;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public Cate getCate() {
        return cate;
    }

    public void setCate(Cate cate) {
        this.cate = cate;
    }
}
