package com.globallogic.demojpa.repo;
import com.globallogic.demojpa.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.globallogic.demojpa.entity.ProductEntity;

public interface CustomerRepo extends JpaRepository<ProductEntity, Integer> {
	 public CustomerEntity getCustomerByEmailAndName(String email,String name);

}
