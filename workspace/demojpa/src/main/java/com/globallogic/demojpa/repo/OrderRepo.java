package com.globallogic.demojpa.repo;
import com.globallogic.demojpa.entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.demojpa.entity.ProductEntity;

public interface OrderRepo extends JpaRepository<ProductEntity, Integer> {

}

