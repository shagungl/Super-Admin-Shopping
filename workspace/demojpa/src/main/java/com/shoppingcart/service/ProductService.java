package com.shoppingcart.service;

import  com.globallogic.demojpa.entity.ProductEntity;
import  com.globallogic.demojpa.repo.ProductRepo;

import  org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductService {

    private ProductRepo productRepository;

    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> getAllProducts() {
        return this.productRepository.findAll();
    }
}


