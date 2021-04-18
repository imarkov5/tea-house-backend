package com.irinamarkov.teahouse.controllers;

import com.irinamarkov.teahouse.entities.Customer;
import com.irinamarkov.teahouse.entities.CustomerAddress;
import com.irinamarkov.teahouse.services.CustomerAddressService;
import com.irinamarkov.teahouse.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerAddressService addressService;

    @GetMapping(path="")
    public List<Customer> getAllCustomers(){
        return this.customerService.getAllCustomers();
    }
    @PostMapping(path="")
    public Customer createCustomer(@RequestBody Customer newCustomer){
        return this.customerService.createCustomer(newCustomer);
    }
    @GetMapping(path="/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return this.customerService.getOneCustomer(id);
    }
    @PutMapping(path ="")
    public Customer updateCustomer(@RequestBody Customer updatedCustomer){
        return this.customerService.updateCustomer(updatedCustomer);
    }
    @DeleteMapping(path="/{id}")
    public void deleteCustomer(@PathVariable Long id){
        this.customerService.deleteCustomer(id);
    }
    @PostMapping(path="/addAddress")
    public void addAddress(@RequestBody Customer customer, @RequestBody CustomerAddress address){
        this.customerService.updateCustomer(customer).setCustomerAddress(address);
    }
}
