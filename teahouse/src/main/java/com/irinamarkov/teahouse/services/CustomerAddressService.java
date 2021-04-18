package com.irinamarkov.teahouse.services;


import com.irinamarkov.teahouse.entities.CustomerAddress;
import com.irinamarkov.teahouse.repos.CustomerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerAddressService {
    @Autowired
    CustomerAddressRepository customerAddressRepo;

    public CustomerAddress createAddress(CustomerAddress newAddress){
        return this.customerAddressRepo.save(newAddress);
    }
    public CustomerAddress getOneAddress(Long id){
        return this.customerAddressRepo.findById(id).orElse(null);
    }
    public CustomerAddress updateAddress(CustomerAddress updatedAddress){
        return this.customerAddressRepo.save(updatedAddress);
    }
    public void deleteAddress(Long id){
        this.customerAddressRepo.deleteById(id);
    }
}
