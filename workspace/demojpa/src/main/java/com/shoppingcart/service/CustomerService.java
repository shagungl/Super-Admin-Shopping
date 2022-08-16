package com.shoppingcart.service;
import  com.globallogic.demojpa.entity.CustomerEntity;
import com.globallogic.demojpa.repo.CustomerRepo;
import org.springframework.stereotype.Service;
@Service
public class CustomerService {

    private CustomerRepo customerRepository;

    public CustomerService(CustomerRepo customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity saveCustomer(CustomerEntity customer){
        return customerRepository.save(customer);
    }

    public Integer isCustomerPresent(CustomerEntity customer){
        CustomerEntity customer1 = customerRepository.getCustomerByEmailAndName(customer.getEmail(),customer.getName());
        return customer1!=null ? customer1.getId(): null ;
    }
}
