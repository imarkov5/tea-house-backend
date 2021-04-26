package com.irinamarkov.teahouse.controllers;

import com.irinamarkov.teahouse.entities.Customer;
import com.irinamarkov.teahouse.entities.CustomerAddress;
import com.irinamarkov.teahouse.services.CustomerAddressService;
import com.irinamarkov.teahouse.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(){
        return this.customerService.getAllCustomers();
    }

    @PostMapping(path="")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer newCustomer){
        return this.customerService.createCustomer(newCustomer);
    }

    @GetMapping(path="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable Long id){
        return this.customerService.getOneCustomer(id);
    }

    @PutMapping(path ="")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer updateCustomer(@RequestBody Customer updatedCustomer){
        return this.customerService.updateCustomer(updatedCustomer);
    }
    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id){
        this.customerService.deleteCustomer(id);
    }

    @PostMapping(path="/{id}/add_address")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAddress(@PathVariable int id, @RequestBody CustomerAddress address){
        this.addressService.createAddress(id, address);
    }
}
