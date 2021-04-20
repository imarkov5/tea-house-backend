package com.irinamarkov.teahouse.controllers;

import com.irinamarkov.teahouse.entities.Order;
import com.irinamarkov.teahouse.entities.OrderItem;
import com.irinamarkov.teahouse.entities.Product;
import com.irinamarkov.teahouse.services.OrderItemService;
import com.irinamarkov.teahouse.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/orders")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderItemService orderItemService;

    @GetMapping (path = "")
    public List<Order> getAllOrders(){
        return this.orderService.getAllOrders();
    }
    @PostMapping (path="")
    public Order createOrder(@RequestBody Order newOrder){
        return this.orderService.createOrder(newOrder);
    }
    @GetMapping(path="/{id}")
    public Order getOrder(@PathVariable Long id){
        return this.orderService.getOneOrder(id);
    }
    @PutMapping(path="")
    public Order updateOrder(@RequestBody Order updatedOrder){
        return this.orderService.updateOrder(updatedOrder);
    }
    @DeleteMapping(path="/{id}")
    public void deleteOrder(@PathVariable Long id){
        this.orderService.deleteOrder(id);
    }


}
