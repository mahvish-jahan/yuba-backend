package com.yuba.cafe.service;

import com.yuba.cafe.model.Address;
import com.yuba.cafe.reporsitory.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    public Address add(Address address) {
        return addressRepo.save(address);
    }

    public List<Address> list(Long userId) {
        return new ArrayList<>(addressRepo.findAllByUserId(userId));
    }

    public Address currentAddress(Long userId) {

        List<Address> allByUserId = addressRepo.findAllByUserId(userId);

        if (!allByUserId.isEmpty()) {
            return allByUserId.get(0);
        }
        return null;
    }
}
