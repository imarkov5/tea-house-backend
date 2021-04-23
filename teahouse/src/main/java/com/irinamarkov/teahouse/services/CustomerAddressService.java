package com.irinamarkov.teahouse.services;

import com.irinamarkov.teahouse.entities.CustomerAddress;
import com.irinamarkov.teahouse.repos.CustomerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerAddressService {
    @Autowired
    CustomerAddressRepository customerAddressRepo;

    public CustomerAddress createAddress(int id, CustomerAddress newAddress){
        newAddress.setCustomer_id(id);
        return this.customerAddressRepo.save(newAddress);
    }
    public CustomerAddress getOneAddress(Long id){
        return this.customerAddressRepo.findById(id).orElse(null);
    }
}
