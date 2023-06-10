package com.yuba.cafe.dto;

import com.yuba.cafe.model.cart.Cart;
import com.yuba.cafe.model.cart.CartLine;
import lombok.Data;

import java.util.List;

@Data
public class CartDto {

    private Cart cart;
    private List<CartLine> cartItemList;
}
