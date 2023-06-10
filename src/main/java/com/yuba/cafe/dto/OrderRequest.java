package com.yuba.cafe.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private Long addressId;
    private List<OrderItemDto> orderItem;
}
