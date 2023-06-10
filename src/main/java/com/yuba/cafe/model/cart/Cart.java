package com.yuba.cafe.model.cart;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long userId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Set<CartLine> cartLines;
}
