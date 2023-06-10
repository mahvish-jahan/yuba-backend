package com.yuba.cafe.model.order;

import com.yuba.cafe.model.Snack;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "snack_id", referencedColumnName = "id")
    private Snack snack;
    private Long count;
}
