package com.yuba.cafe.reporsitory;

import com.yuba.cafe.model.order.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {
    List<Order> findAll();
    List<Order> findAllByUserIdOrderByIdDesc(Long userId);
}
