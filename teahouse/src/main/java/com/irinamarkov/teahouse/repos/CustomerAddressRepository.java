package com.irinamarkov.teahouse.repos;

import com.irinamarkov.teahouse.entities.CustomerAddress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAddressRepository extends CrudRepository<CustomerAddress, Long> {
    List<CustomerAddress>findAll();
}
