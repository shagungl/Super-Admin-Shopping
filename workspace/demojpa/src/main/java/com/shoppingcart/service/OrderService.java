package com.shoppingcart.service;

import  com.globallogic.demojpa.entity.OrderEntity;

import  com.globallogic.demojpa.entity.ShoppingCart;
import  com.globallogic.demojpa.entity.ProductEntity;
import  com.globallogic.demojpa.repo.OrderRepo;
import  com.globallogic.demojpa.repo.ProductRepo;
import  com.globallogic.demojpa.repo.CustomerRepo;
import  org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepo orderRepository;
    private ProductRepo productRepository;

    public OrderService(OrderRepo orderRepository, ProductRepo productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public OrderEntity getOrderDetail(int orderId) {
        Optional<OrderEntity> order = this.OrderRepo.findById(orderId);
        return order.isPresent() ? order.get() : null;
    }

    public float getCartAmount(List<ShoppingCart> shoppingCartList) {

        float totalCartAmount = 0f;
        float singleCartAmount = 0f;
        int availableQuantity = 0;

        for (ShoppingCart cart : shoppingCartList) {

            int productId = cart.getProductId();
            Optional<ProductEntity> product = productRepository.findById(productId);
            if (product.isPresent()) {
                ProductEntity product1 = product.get();
                if (product1.getAvailableQuantity() < cart.getQuantity()) {
                    singleCartAmount = product1.getPrice() * product1.getAvailableQuantity();
                    cart.setQuantity(product1.getAvailableQuantity());
                } else {
                    singleCartAmount = cart.getQuantity() * product1.getPrice();
                    availableQuantity = product1.getAvailableQuantity() - cart.getQuantity();
                }
                totalCartAmount = totalCartAmount + singleCartAmount;
                product1.setAvailableQuantity(availableQuantity);
                availableQuantity=0;
                cart.setProductName(product1.getName());
                cart.setAmount(singleCartAmount);
                productRepository.save(product1);
            }
        }
        return totalCartAmount;
    }

    public OrderEntity saveOrder(OrderEntity order) {
        return orderRepository.save(order);
    }
}
