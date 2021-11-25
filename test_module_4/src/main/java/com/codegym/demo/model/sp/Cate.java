package com.codegym.demo.model.sp;

import com.codegym.demo.model.st.Customer;
import com.codegym.demo.model.student.Student;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameCate;
    @OneToMany(targetEntity = Product.class)
    private List<Product> productList;

    public Cate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
