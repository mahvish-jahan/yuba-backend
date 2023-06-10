package com.yuba.cafe.reporsitory;

import com.yuba.cafe.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepo extends CrudRepository<Address, Long> {
    List<Address> findAllByUserId(Long userId);
}
