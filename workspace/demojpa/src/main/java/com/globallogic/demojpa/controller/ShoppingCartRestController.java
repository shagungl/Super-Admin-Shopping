package com.globallogic.demojpa.controller;

import com.globallogic.demojpa.entity.ShoppingCart;
import com.globallogic.demojpa.entity.CustomerEntity;
import com.globallogic.demojpa.entity.MerchantEntity;
import com.globallogic.demojpa.entity.OrderEntity;
import com.globallogic.demojpa.entity.ProductEntity;
import com.shoppingcart.service.OrderService;
import com.shoppingcart.service.ProductService;
import com.shoppingcart.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class ShoppingCartRestController {

    private OrderService orderService;
    private ProductService productService;
    private CustomerService customerService;


    public ShoppingCartRestController(OrderService orderService, ProductService productService, CustomerService customerService) {
        this.orderService = orderService;
        this.productService = productService;
        this.customerService = customerService;
    }

    private Logger logger = LoggerFactory.getLogger(ShoppingCartRestController.class);

    @GetMapping(value = "/getAllProducts")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {

        List<ProductEntity> productList = productService.getAllProducts();

        return ResponseEntity.ok(productList);
    }

    @GetMapping(value = "/getOrder/{orderId}")
    public ResponseEntity<OrderEntity> getOrderDetails(@PathVariable int orderId) {

        OrderEntity order = orderService.getOrderDetail(orderId);
        return ResponseEntity.ok(order);
    }


    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        logger.info("Request Payload " + orderDTO.toString());
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
        float amount = orderService.getCartAmount(orderDTO.getCartItems());

        CustomerEntity customer = new CustomerEntity(orderDTO.getCustomerName(), orderDTO.getCustomerEmail());
        Integer customerIdFromDb = customerService.isCustomerPresent(customer);
        if (customerIdFromDb != null) {
            customer.setId(customerIdFromDb);
            logger.info("Customer already present in db with id : " + customerIdFromDb);
        }else{
            customer = customerService.saveCustomer(customer);
            logger.info("Customer saved.. with id : " + customer.getId());
        }
        OrderEntity order = new Order(orderDTO.getOrderDescription(), customer, orderDTO.getCartItems());
        order = orderService.saveOrder(order);
        logger.info("Order processed successfully..");

        responseOrderDTO.setAmount(amount);
        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
        responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
        responseOrderDTO.setOrderId(order.getId());
        responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());

        logger.info("test push..");

        return ResponseEntity.ok(responseOrderDTO);
    }

}


