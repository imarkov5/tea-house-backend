package com.irinamarkov.teahouse.services;

import com.irinamarkov.teahouse.entities.Customer;
import com.irinamarkov.teahouse.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepo;

    public List<Customer> getAllCustomers(){
        return this.customerRepo.findAll();
    }

    public Customer createCustomer(Customer newCustomer){
        return this.customerRepo.save(newCustomer);
    }

    public Customer getOneCustomer(Long id){
        return this.customerRepo.findById(id).orElse(null);
    }

    public Customer updateCustomer(Customer updatedCustomer){
        return this.customerRepo.save(updatedCustomer);
    }

    public void deleteCustomer(Long id){
        this.customerRepo.deleteById(id);
    }

}
