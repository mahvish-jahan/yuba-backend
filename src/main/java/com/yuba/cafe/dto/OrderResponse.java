package com.yuba.cafe.dto;

import com.yuba.cafe.model.order.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {

    private Long id;
    private Long addressId;
    private Long userId;
    private List<OrderItem> orderItem;
}
