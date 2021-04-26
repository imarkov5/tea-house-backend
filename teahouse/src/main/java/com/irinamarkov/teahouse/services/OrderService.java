package com.irinamarkov.teahouse.services;

import com.irinamarkov.teahouse.entities.Order;
import com.irinamarkov.teahouse.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepo;

    public List<Order> getAllOrders(){
        return this.orderRepo.findAll();
    }

    public Order createOrder(Order newOrder){
        return this.orderRepo.save(newOrder);
    }

    public Order getOneOrder(Long id){
        return this.orderRepo.findById(id).orElse(null);
    }

    public Order updateOrder(Order updatedOrder){
        return this.orderRepo.save(updatedOrder);
    }

    public void deleteOrder(Long id){
        this.orderRepo.deleteById(id);
    }
}
