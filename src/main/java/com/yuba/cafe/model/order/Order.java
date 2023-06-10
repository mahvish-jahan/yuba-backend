package com.yuba.cafe.model.order;

import com.yuba.cafe.model.Address;
import com.yuba.cafe.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double totalAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Set<OrderItem> orderItems;

    private OrderState orderState;
}
