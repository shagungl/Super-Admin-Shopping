package com.globallogic.demojpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.demojpa.entity.ProductEntity;

public interface ShoppingCartRepo extends JpaRepository<ProductEntity, Integer> {

}
