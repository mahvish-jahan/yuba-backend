package com.yuba.cafe.reporsitory;

import com.yuba.cafe.model.cart.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepo extends CrudRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}
