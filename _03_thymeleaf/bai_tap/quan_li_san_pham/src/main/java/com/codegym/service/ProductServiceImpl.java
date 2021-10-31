package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements IProductService {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone X",12.5,"X","Apple" ));
        products.put(2, new Product(2, "Iphone 11",15,"11","Apple" ));
        products.put(3, new Product(3, "Iphone 12",19.8,"12","Apple" ));
        products.put(4, new Product(4, "Iphone 13",27.2,"13","Apple" ));



    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = findAll();
        List<Product> products = new ArrayList<>();
        for(Product product: productList){
            if( product.getName().contains(name)){
                products.add(product);
            }
        }
        return products;
    }
}