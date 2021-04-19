package com.irinamarkov.teahouse.services;

import com.irinamarkov.teahouse.entities.OrderItem;
import com.irinamarkov.teahouse.repos.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepo;

    public OrderItem createOrderItem(OrderItem newItem){
        return this.orderItemRepo.save(newItem);
    }

    public OrderItem readOrderItem(Long id){
        return this.orderItemRepo.findById(id).orElse(null);
    }

    public OrderItem updateOrderItem(OrderItem updatedItem){
        return this.orderItemRepo.save(updatedItem);
    }

    public void deleteOrderItem(Long id){
        this.orderItemRepo.deleteById(id);
    }
}
