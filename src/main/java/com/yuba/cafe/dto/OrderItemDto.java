package com.yuba.cafe.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long menuId;
    private Long quantity;
}
